package com.wooyoungsoo.api_server.bloodsugar.mapper;

import com.wooyoungsoo.api_server.bloodsugar.dto.BloodSugarDTO;
import com.wooyoungsoo.api_server.bloodsugar.entity.BloodSugar;
import com.wooyoungsoo.api_server.chart.dto.LineChartDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Getter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
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

    public LineChartDTO toDTO(BloodSugar bloodSugar) {

        return LineChartDTO.builder()
                .timestampEpoch(bloodSugar.getTimestamp().atZone(ZoneOffset.UTC).toInstant().toEpochMilli())
                .pastBloodSugar(bloodSugar.getPastBloodSugar())
                .build();
    }

}
