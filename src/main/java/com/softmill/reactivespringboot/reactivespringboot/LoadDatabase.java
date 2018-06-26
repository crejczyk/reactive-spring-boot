package com.softmill.reactivespringboot.reactivespringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

import com.softmill.reactivespringboot.reactivespringboot.model.Image;

@Configuration
public class LoadDatabase {

	/*
	 * @Bean CommandLineRunner init(ChapterRepository repository) { return args -> {
	 * Flux.just( new Chapter("Quick Start with Java"), new
	 * Chapter("Reactive Web with Spring Boot"), new Chapter("...and more!"))
	 * .flatMap(repository::save) .subscribe(System.out::println); }; }
	 */

	@Bean
	CommandLineRunner init(MongoOperations operations) {
		return args -> {
			operations.dropCollection(Image.class);

			operations.insert(new Image("1", "learning-spring-boot-cover.jpg"));
			operations.insert(new Image("2", "learning-spring-boot-2nd-edition-cover.jpg"));
			operations.insert(new Image("3", "bazinga.png"));

			operations.findAll(Image.class).forEach(image -> {
				System.out.println(image.toString());
			});
		};
	}

}