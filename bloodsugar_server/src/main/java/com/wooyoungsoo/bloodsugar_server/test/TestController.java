package com.wooyoungsoo.bloodsugar_server.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestEntityRepository testEntityRepository;

    @Autowired
    public TestController(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    @GetMapping
    public List<TestEntity> getAllTestEntities() {
        return testEntityRepository.findAll();
    }
}
