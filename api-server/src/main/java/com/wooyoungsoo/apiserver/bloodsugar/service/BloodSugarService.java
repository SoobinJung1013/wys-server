package com.wooyoungsoo.apiserver.bloodsugar.service;


import com.wooyoungsoo.apiserver.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.apiserver.chart.dto.LineChartDTO;

import java.util.List;

public interface BloodSugarService {
    BloodSugarDTO createBloodSugar(BloodSugarDTO bloodSugarDTO);

    List<BloodSugarDTO> getAllBloodSugar();

    List<LineChartDTO> getBloodSugarByDeviceType(Integer deviceType);
}
