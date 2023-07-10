package com.wooyoungsoo.bloodsugar_server.bloodsugar.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class BloodSugarLineChartDTO {
    private Long timestampEpoch;
    private Integer pastBloodSugar;
}
