package com.softmill.reactivespringboot.reactivespringboot.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.softmill.reactivespringboot.reactivespringboot.model.Tweet;

@Repository
public interface TweetRepository extends ReactiveCrudRepository<Tweet, String> {

}