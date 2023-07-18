package com.wooyoungsoo.bloodsugar_server.feed.dao;

import com.wooyoungsoo.bloodsugar_server.feed.entity.DogFeed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogFeedDAO extends MongoRepository<DogFeed, String> {
}
