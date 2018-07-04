package com.softmill.reactivespringboot.reactivespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringBootApplication.class, args);
	}
	
	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	
}
