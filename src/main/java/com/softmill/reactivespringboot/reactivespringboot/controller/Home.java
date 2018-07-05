package com.softmill.reactivespringboot.reactivespringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softmill.reactivespringboot.reactivespringboot.model.Tweet;
import com.softmill.reactivespringboot.reactivespringboot.repository.TweetRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class Home {

	@GetMapping("")
	public Mono<String> index() {
		return Mono.just("index");
	}
	
}