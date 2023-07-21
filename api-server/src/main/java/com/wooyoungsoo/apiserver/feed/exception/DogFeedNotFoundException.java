package com.wooyoungsoo.apiserver.feed.exception;

public class DogFeedNotFoundException extends RuntimeException {
    public DogFeedNotFoundException(String message) {
        super(message);
    }
}
