package com.wooyoungsoo.apiserver.chart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Data
public class LineChartDTO {
    private Long timestampEpoch;
    private Integer pastBloodSugar;
}
