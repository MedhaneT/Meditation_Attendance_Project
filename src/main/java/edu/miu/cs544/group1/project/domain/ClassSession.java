package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassSession {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"sessions"}, allowSetters = true)
    private CourseOffering courseOffering;
    @ManyToOne
    @JoinColumn
    private Location location;
    @ManyToMany
    private List<TimeSlot> timeSlots = new ArrayList<>();

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);

    }
}
