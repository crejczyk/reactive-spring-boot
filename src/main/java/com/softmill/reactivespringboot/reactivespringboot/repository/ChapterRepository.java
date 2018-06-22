package com.softmill.reactivespringboot.reactivespringboot.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.softmill.reactivespringboot.reactivespringboot.model.Chapter;

public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {

}