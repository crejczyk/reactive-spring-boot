package com.softmill.reactivespringboot.reactivespringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.softmill.reactivespringboot.reactivespringboot.model.Tweet;
import com.softmill.reactivespringboot.reactivespringboot.repository.TweetRepository;

import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {
	
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);
    
    private final TweetRepository tweetRepository;
 
	public LoadDatabase(TweetRepository tweetRepository,PasswordEncoder passwordEncoder) {
		this.tweetRepository = tweetRepository;
	}

	@EventListener(value = ContextRefreshedEvent.class)
	void init() {
		initTweets();
	}

    private void initTweets() {
        log.info("Start data initialization  ...");
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