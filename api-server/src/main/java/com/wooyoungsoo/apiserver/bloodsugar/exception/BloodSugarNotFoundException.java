package com.wooyoungsoo.apiserver.bloodsugar.exception;

public class BloodSugarNotFoundException extends RuntimeException {
    public BloodSugarNotFoundException(String message) {
        super(message);
    }
}
