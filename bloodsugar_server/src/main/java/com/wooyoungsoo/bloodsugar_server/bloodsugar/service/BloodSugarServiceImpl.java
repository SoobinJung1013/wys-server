package com.wooyoungsoo.bloodsugar_server.bloodsugar.service;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dao.BloodSugarDAO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.exception.BloodSugarNotFoundException;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.mapper.BloodSugarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloodSugarServiceImpl implements BloodSugarService{
    private final BloodSugarDAO bloodSugarDAO;

    @Autowired
    public BloodSugarServiceImpl(BloodSugarDAO bloodSugarDAO) {
        this.bloodSugarDAO = bloodSugarDAO;
    }

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
}
