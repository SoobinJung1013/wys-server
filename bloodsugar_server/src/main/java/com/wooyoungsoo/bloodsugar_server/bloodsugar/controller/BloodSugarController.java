package com.wooyoungsoo.bloodsugar_server.bloodsugar.controller;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarLineChartDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.service.BloodSugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blood-sugar")
public class BloodSugarController {
    private final BloodSugarService bloodSugarService;

    @Autowired
    public BloodSugarController(BloodSugarService bloodSugarService) {
        this.bloodSugarService = bloodSugarService;
    }

    @PostMapping
    public BloodSugarDTO createBloodSugar(@RequestBody BloodSugarDTO bloodSugarDTO) {
        return bloodSugarService.createBloodSugar(bloodSugarDTO);
    }

    @GetMapping("/{id}")
    public BloodSugarDTO getBloodSugarById(@PathVariable Long id) {
        return bloodSugarService.getBloodSugarById(id);
    }

    @GetMapping
    public List<BloodSugarDTO> getAllBloodSugar() {
        return bloodSugarService.getAllBloodSugar();
    }

    @GetMapping("/lines")
    public List<BloodSugarLineChartDTO> getBloodSugarByDeviceType() {
        Integer deviceType = 0; // 원하는 deviceType 값을 설정하세요
        return bloodSugarService.getBloodSugarByDeviceType(deviceType);
    }
}
