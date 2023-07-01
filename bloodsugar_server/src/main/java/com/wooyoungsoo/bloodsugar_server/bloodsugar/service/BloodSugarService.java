package com.wooyoungsoo.bloodsugar_server.bloodsugar.service;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;

import java.util.List;

public interface BloodSugarService {
    BloodSugarDTO createBloodSugar(BloodSugarDTO bloodSugarDTO);
    BloodSugarDTO getBloodSugarById(Long id);
    List<BloodSugarDTO> getAllBloodSugar();
}
