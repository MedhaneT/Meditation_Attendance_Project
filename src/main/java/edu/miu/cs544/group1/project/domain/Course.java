package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties(value = {"registrations"}, allowSetters = true)
    private List<CourseOffering> courseOfferings = new ArrayList<>();

    public void addCourseOffering(CourseOffering courseOffering) {
        courseOfferings.add(courseOffering);
    }
}
