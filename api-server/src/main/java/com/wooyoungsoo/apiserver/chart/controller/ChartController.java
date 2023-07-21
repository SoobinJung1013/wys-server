package com.wooyoungsoo.apiserver.chart.controller;


import com.wooyoungsoo.apiserver.bloodsugar.service.BloodSugarService;
import com.wooyoungsoo.apiserver.chart.dto.LineChartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/charts")
public class ChartController {
    private final BloodSugarService bloodSugarService;

    @Autowired
    public ChartController(BloodSugarService bloodSugarService) {
        this.bloodSugarService = bloodSugarService;
    }

    @GetMapping("/lines")
    public List<LineChartDTO> getBloodSugarByDeviceType() {
        Integer deviceType = 0;
        return bloodSugarService.getBloodSugarByDeviceType(deviceType);
    }
}
