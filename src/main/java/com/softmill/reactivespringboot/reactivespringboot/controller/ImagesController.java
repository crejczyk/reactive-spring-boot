package com.softmill.reactivespringboot.reactivespringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.softmill.reactivespringboot.reactivespringboot.model.Image;

@RestController
public class ImagesController {

	private static final Logger log = LoggerFactory.getLogger(ImagesController.class);

	private static final String API_BASE_PATH = "/api";

	@GetMapping(API_BASE_PATH + "/images")
	Flux<Image> images() {
		return Flux.just(new Image("1", "learning-spring-boot-cover.jpg"),
				new Image("2", "learning-spring-boot-2nd-edition-cover.jpg"), new Image("3", "bazinga.png"));
	}

	@PostMapping(API_BASE_PATH + "/images")
	Mono<Void> create(@RequestPart Flux<FilePart> images) {
		return images.map(image -> {
			log.info("We will save " + image + " to a Reactive database soon!");
			return image;
		}).then();
	}

}