package com.wooyoungsoo.bloodsugar_server.bloodsugar.service;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.bloodsugar_server.chart.dto.LineChartDTO;

import java.util.List;

public interface BloodSugarService {
    BloodSugarDTO createBloodSugar(BloodSugarDTO bloodSugarDTO);

    List<BloodSugarDTO> getAllBloodSugar();

    List<LineChartDTO> getBloodSugarByDeviceType(Integer deviceType);
}
