package com.wooyoungsoo.bloodsugar_server.feed.controller;

import com.wooyoungsoo.bloodsugar_server.feed.dao.DogFeedDAO;
import com.wooyoungsoo.bloodsugar_server.feed.entity.DogFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedController {

    private final DogFeedDAO dogFeedDAO;

    @Autowired
    public FeedController(DogFeedDAO dogFeedDAO) {
        this.dogFeedDAO = dogFeedDAO;
    }

    @GetMapping
    public List<DogFeed> getAllFeeds() {
        return dogFeedDAO.findAll();
    }
}
