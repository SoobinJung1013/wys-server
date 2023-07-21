package com.wooyoungsoo.api_server.feed.exception;

public class DogFeedNotFoundException extends RuntimeException {
    public DogFeedNotFoundException(String message) {
        super(message);
    }
}
