package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"courseOfferings"}, allowSetters = true)
    private Course course;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private Faculty faculty;

    @OneToMany(mappedBy = "courseOffering")
    @JsonIgnoreProperties(value = {"courseOffering"}, allowSetters = true)
    private List<Registration> registrations;
    @OneToMany(mappedBy = "courseOffering")
    @JsonIgnoreProperties(value = {"courseOffering"}, allowSetters = true)
    private List<ClassSession> sessions;

    public void addRegistration(Registration registration) {
        registration.setCourseOffering(this);
        registrations.add(registration);
    }

    public void addClassSession(ClassSession classSession) {
        classSession.setCourseOffering(this);
        sessions.add(classSession);
    }

    @Override
    public String toString() {
        return "CourseOffering{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", course=" + course +
                ", faculty=" + faculty +
                '}';
    }
}
