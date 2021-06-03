package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CourseOffering {
    @Id
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    private Course course;

    @ManyToOne
    @JoinColumn
    private Faculty faculty;

    @OneToMany(mappedBy = "courseOffering")
    private List<Registration> registrations;
    @OneToMany(mappedBy = "courseOffering")
    private List<ClassSession> sessions;
}
