package com.wooyoungsoo.bloodsugar_server.bloodsugar.repository;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {

}