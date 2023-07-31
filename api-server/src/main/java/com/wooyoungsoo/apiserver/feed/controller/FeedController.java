package com.wooyoungsoo.apiserver.feed.controller;

import com.wooyoungsoo.apiserver.feed.dao.DogFeedDAO;
import com.wooyoungsoo.apiserver.feed.entity.DogFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feeds")
public class FeedController {
    private final DogFeedDAO dogFeedDAO;

    @Autowired
    public FeedController(DogFeedDAO dogFeedDAO) {
        this.dogFeedDAO = dogFeedDAO;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "dog_feeds", key = "#id")
    public DogFeed getFeedById(@PathVariable String id) {
        return dogFeedDAO.findById(id).orElse(null);
    }

    @GetMapping
    @Cacheable("popular_dog_feeds")
    public List<DogFeed> getAllFeeds() {
//        return dogFeedDAO.findAll(Sort.by(Sort.Direction.ASC, "rank")).stream()
        return dogFeedDAO.findAll().stream()
                .limit(100)
                .collect(Collectors.toList());
    }
}
