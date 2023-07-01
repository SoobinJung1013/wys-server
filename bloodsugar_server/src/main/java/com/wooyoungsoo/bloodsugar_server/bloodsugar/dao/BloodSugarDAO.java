package com.wooyoungsoo.bloodsugar_server.bloodsugar.dao;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodSugarDAO extends JpaRepository<BloodSugar, Long> {
    BloodSugar save(BloodSugar bloodSugar);
    Optional<BloodSugar> findById(Long id);
    List<BloodSugar> findAll();
//    BloodSugar update(BloodSugar bloodSugar);
//    void deleteById(Long id);
}
