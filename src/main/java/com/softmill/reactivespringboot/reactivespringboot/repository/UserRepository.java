package com.softmill.reactivespringboot.reactivespringboot.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.softmill.reactivespringboot.reactivespringboot.model.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

	Mono<User> findByUsername(String username);
}