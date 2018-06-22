package com.softmill.reactivespringboot.reactivespringboot;

import reactor.core.publisher.Flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.softmill.reactivespringboot.reactivespringboot.model.Chapter;
import com.softmill.reactivespringboot.reactivespringboot.repository.ChapterRepository;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner init(ChapterRepository repository) {
		return args -> {
			Flux.just(
				new Chapter("Quick Start with Java"),
				new Chapter("Reactive Web with Spring Boot"),
				new Chapter("...and more!"))
			.flatMap(repository::save)
			.subscribe(System.out::println);
		};
	}

}