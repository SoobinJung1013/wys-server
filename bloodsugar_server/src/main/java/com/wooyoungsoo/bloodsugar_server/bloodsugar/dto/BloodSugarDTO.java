package com.wooyoungsoo.bloodsugar_server.bloodsugar.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Data
public class BloodSugarDTO {
    private Long id;
    private LocalDateTime timestamp;
    private Integer deviceType;
    private Integer pastBloodSugar;
    private Integer scanBloodSugar;
}
