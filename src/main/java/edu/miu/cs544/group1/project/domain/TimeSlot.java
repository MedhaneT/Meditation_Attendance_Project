package edu.miu.cs544.group1.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    @Id
    @Column(length = 2, nullable = false)
    private String abbreviation; // AM, PM
    @Column(nullable = false)
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
}