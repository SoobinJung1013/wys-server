package com.wooyoungsoo.apiserver.bloodsugar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blood_sugar")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodSugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String device;

    @Column(name = "serial_number", nullable = true)
    private String serialNumber;

    @Column(nullable = true)
    private LocalDateTime timestamp;

    @Column(name = "device_type", nullable = true)
    private Integer deviceType;

    @Column(name = "past_blood_sugar")
    private Integer pastBloodSugar;

    @Column(name = "scan_blood_sugar")
    private Integer scanBloodSugar;
}
