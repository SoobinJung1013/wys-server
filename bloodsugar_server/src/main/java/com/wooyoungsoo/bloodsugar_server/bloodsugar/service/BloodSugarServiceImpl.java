package com.wooyoungsoo.bloodsugar_server.bloodsugar.service;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dao.BloodSugarDAO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarLineChartDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.exception.BloodSugarNotFoundException;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.mapper.BloodSugarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
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
    public BloodSugarDTO getBloodSugarById(Long id) {
        BloodSugar bloodSugar = bloodSugarDAO.findById(id)
                .orElseThrow(() -> new BloodSugarNotFoundException("Blood sugar not found"));
        return BloodSugarMapper.mapEntityToDto(bloodSugar);
    }

    @Override
    public List<BloodSugarDTO> getAllBloodSugar() {
        List<BloodSugar> bloodSugarList = bloodSugarDAO.findAll();
        return bloodSugarList.stream()
                .map(BloodSugarMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BloodSugarLineChartDTO> getBloodSugarByDeviceType(Integer deviceType) {
//        LocalDateTime start = LocalDateTime.now().minusDays(1);
//        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.parse("2023-06-02T18:30:00.000");
        LocalDateTime end = LocalDateTime.parse("2023-06-03T18:30:00.000");

        if (bloodSugarDAO == null || bloodSugarMapper == null) {
            // DAO 또는 Mapper 객체가 null인 경우 예외 처리
            throw new IllegalStateException("bloodSugarDAO or bloodSugarMapper is not initialized");
        }

        List<BloodSugar> bloodSugars = bloodSugarDAO.findByDeviceTypeAndTimestampBetween(deviceType, start, end);
        if (bloodSugars == null) {
            // 조회 결과가 null인 경우 예외 처리 또는 빈 리스트 반환 등의 처리
            return Collections.emptyList();
        }

        return bloodSugars.stream()
                .map(bloodSugarMapper::toDTO)
                .collect(Collectors.toList());
    }

}
