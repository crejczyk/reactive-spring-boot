package com.softmill.reactivespringboot.reactivespringboot.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.softmill.reactivespringboot.reactivespringboot.model.Image;

import reactor.core.publisher.Mono;

public interface ImageRepository extends ReactiveCrudRepository<Image, String> {

	Mono<Image> findByName(String name);
}