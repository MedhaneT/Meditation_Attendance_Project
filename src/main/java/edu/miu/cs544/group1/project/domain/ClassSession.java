package edu.miu.cs544.group1.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ClassSession {
    @Id
    private Integer id;
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn
    private CourseOffering courseOffering;
    @ManyToOne
    @JoinColumn
    private Location location;
    @ManyToMany
    private List<TimeSlot> timeSlots;
}
