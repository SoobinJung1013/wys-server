package com.wooyoungsoo.bloodsugar_server.chart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class LineChartDTO {
    private Long timestampEpoch;
    private Integer pastBloodSugar;
}
