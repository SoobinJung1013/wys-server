package com.wooyoungsoo.apiserver.feed.dao;


import com.wooyoungsoo.apiserver.feed.entity.DogFeed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogFeedDAO extends MongoRepository<DogFeed, String> {
}
