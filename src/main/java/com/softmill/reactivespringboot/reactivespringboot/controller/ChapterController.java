package com.softmill.reactivespringboot.reactivespringboot.controller;

import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softmill.reactivespringboot.reactivespringboot.model.Chapter;
import com.softmill.reactivespringboot.reactivespringboot.repository.ChapterRepository;

@RestController
public class ChapterController {
	private final ChapterRepository repository;

	public ChapterController(ChapterRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/chapters")
	public Flux<Chapter> listing() {
		return repository.findAll();
	}
}