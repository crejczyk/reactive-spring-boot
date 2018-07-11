package com.softmill.reactivespringboot.reactivespringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class Home {

	@GetMapping()
	public Mono<String> index() {
		return Mono.just("index");
	}
	
}