package com.wooyoungsoo.bloodsugar_server.chart.controller;

import com.wooyoungsoo.bloodsugar_server.chart.dto.LineChartDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.service.BloodSugarService;
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
