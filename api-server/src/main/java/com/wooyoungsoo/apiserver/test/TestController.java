package com.wooyoungsoo.apiserver.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {
    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public void log() {
        logService.log();
    }
}
