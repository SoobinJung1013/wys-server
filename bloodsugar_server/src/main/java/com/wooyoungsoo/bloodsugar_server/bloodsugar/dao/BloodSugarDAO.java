package com.wooyoungsoo.bloodsugar_server.bloodsugar.dao;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BloodSugarDAO extends JpaRepository<BloodSugar, Long> {
    BloodSugar save(BloodSugar bloodSugar);

    List<BloodSugar> findAll();

    List<BloodSugar> findByDeviceTypeAndTimestampBetween(Integer deviceType, LocalDateTime start, LocalDateTime end);
}
