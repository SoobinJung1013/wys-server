package com.wooyoungsoo.api_server.bloodsugar.service;

import com.wooyoungsoo.api_server.bloodsugar.dao.BloodSugarDAO;
import com.wooyoungsoo.api_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.api_server.bloodsugar.entity.BloodSugar;
import com.wooyoungsoo.api_server.bloodsugar.mapper.BloodSugarMapper;
import com.wooyoungsoo.api_server.chart.dto.LineChartDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodSugarServiceImpl implements BloodSugarService{
    private final BloodSugarDAO bloodSugarDAO;

    private final BloodSugarMapper bloodSugarMapper;

    @Override
    public BloodSugarDTO createBloodSugar(BloodSugarDTO bloodSugarDTO) {
        BloodSugar bloodSugar = BloodSugarMapper.mapDtoToEntity(bloodSugarDTO);
        BloodSugar createdBloodSugar = bloodSugarDAO.save(bloodSugar);
        return BloodSugarMapper.mapEntityToDto(createdBloodSugar);
    }

    @Override
    public List<BloodSugarDTO> getAllBloodSugar() {
        List<BloodSugar> bloodSugarList = bloodSugarDAO.findAll();
        return bloodSugarList.stream()
                .map(BloodSugarMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LineChartDTO> getBloodSugarByDeviceType(Integer deviceType) {
//        LocalDateTime start = LocalDateTime.now().minusDays(1);
//        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.parse("2023-06-02T18:30:00.000");
        LocalDateTime end = LocalDateTime.parse("2023-06-03T18:30:00.000");

        if (bloodSugarDAO == null || bloodSugarMapper == null) {
            throw new IllegalStateException("bloodSugarDAO or bloodSugarMapper is not initialized");
        }

        List<BloodSugar> bloodSugars = bloodSugarDAO.findByDeviceTypeAndTimestampBetween(deviceType, start, end);
        if (bloodSugars == null) {
            return Collections.emptyList();
        }

        return bloodSugars.stream()
                .map(bloodSugarMapper::toDTO)
                .collect(Collectors.toList());
    }

}
