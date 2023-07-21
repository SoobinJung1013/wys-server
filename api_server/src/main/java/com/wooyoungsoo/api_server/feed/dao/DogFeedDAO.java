package com.wooyoungsoo.api_server.feed.dao;

import com.wooyoungsoo.api_server.feed.entity.DogFeed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogFeedDAO extends MongoRepository<DogFeed, String> {
}
