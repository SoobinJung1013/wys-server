package com.wooyoungsoo.apiserver.bloodsugar.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@Data
public class BloodSugarDTO {
    private Long id;
    private LocalDateTime timestamp;
    private Integer deviceType;
    private Integer pastBloodSugar;
    private Integer scanBloodSugar;
}
