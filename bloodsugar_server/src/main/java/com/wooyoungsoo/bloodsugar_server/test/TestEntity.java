package com.wooyoungsoo.bloodsugar_server.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 생성자, getter, setter 등 필요한 메소드 추가

    // 기본 생성자
    public TestEntity() {
    }

    public TestEntity(String name) {
        this.name = name;
    }

    // Getter 및 Setter 메소드
    // ...
}
