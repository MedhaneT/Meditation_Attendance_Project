package edu.miu.cs544.group1.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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


    public ClassSession(Location location , List<TimeSlot> timeSlots) {
           this.timeSlots =new  ArrayList<TimeSlot>();
           this.location = location;
    }
}
