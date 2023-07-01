package com.wooyoungsoo.bloodsugar_server.bloodsugar.mapper;

import com.wooyoungsoo.bloodsugar_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.bloodsugar_server.bloodsugar.entity.BloodSugar;

public class BloodSugarMapper {
    public static BloodSugarDTO mapEntityToDto(BloodSugar bloodSugar) {
        return BloodSugarDTO.builder()
                .id(bloodSugar.getId())
                .deviceType(bloodSugar.getDeviceType())
                .pastBloodSugar(bloodSugar.getPastBloodSugar())
                .scanBloodSugar(bloodSugar.getScanBloodSugar())
                .build();
    }

    public static BloodSugar mapDtoToEntity(BloodSugarDTO bloodSugarDTO) {
        return BloodSugar.builder()
                .timestamp(bloodSugarDTO.getTimestamp())
                .deviceType(bloodSugarDTO.getDeviceType())
                .pastBloodSugar(bloodSugarDTO.getPastBloodSugar())
                .scanBloodSugar(bloodSugarDTO.getScanBloodSugar())
                .build();
    }
}
