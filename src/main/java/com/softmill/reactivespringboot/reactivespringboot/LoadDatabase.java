package com.softmill.reactivespringboot.reactivespringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.softmill.reactivespringboot.reactivespringboot.model.Tweet;
import com.softmill.reactivespringboot.reactivespringboot.model.User;
import com.softmill.reactivespringboot.reactivespringboot.repository.TweetRepository;
import com.softmill.reactivespringboot.reactivespringboot.repository.UserRepository;

import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {
	
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);
    
    private final TweetRepository tweetRepository;
    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

 
	public LoadDatabase(TweetRepository tweetRepository, UserRepository users, PasswordEncoder passwordEncoder) {
		this.tweetRepository = tweetRepository;
		this.usersRepository = users;
		this.passwordEncoder = passwordEncoder;
	}

	@EventListener(value = ContextRefreshedEvent.class)
	void init() {
		initTweets();
		initUsers();
	}

    private void initUsers() {
		log.info("start users initialization  ...");
		this.usersRepository
            .deleteAll()
            .thenMany(
                Flux
                    .just("user", "admin")
                    .flatMap(
                        username -> {
                            List<String> roles = "user".equals(username)
                            ? Arrays.asList("ROLE_USER")
                            : Arrays.asList("ROLE_USER", "ROLE_ADMIN");
                            User user = new User(username,passwordEncoder.encode("password"),roles);
                            return this.usersRepository.save(user);
                        }
                    )
            )
            .log()
            .subscribe(
                null,
                null,
                () -> log.info("done users initialization...")
            );
    }
    
    private void initTweets() {
        log.info("start data initialization  ...");
        this.tweetRepository
            .deleteAll()
            .thenMany(
                Flux
                    .just("Tweet one", "Tweet two")
                    .flatMap(
                        text -> this.tweetRepository.save(new Tweet(text))
                    )
            )
            .log()
            .subscribe(
                null,
                null,
                () -> log.info("done initialization...")
            );
    }
}