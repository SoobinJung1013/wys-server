package com.wooyoungsoo.apiserver.bloodsugar.dao;


import com.wooyoungsoo.apiserver.bloodsugar.entity.BloodSugar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BloodSugarDAO extends JpaRepository<BloodSugar, Long> {
    BloodSugar save(BloodSugar bloodSugar);

    List<BloodSugar> findAll();

    List<BloodSugar> findByDeviceTypeAndTimestampBetween(Integer deviceType, LocalDateTime start, LocalDateTime end);
}
