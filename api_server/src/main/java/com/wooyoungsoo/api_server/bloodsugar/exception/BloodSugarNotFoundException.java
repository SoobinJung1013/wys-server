package com.wooyoungsoo.api_server.bloodsugar.exception;

public class BloodSugarNotFoundException extends RuntimeException {
    public BloodSugarNotFoundException(String message) {
        super(message);
    }
}