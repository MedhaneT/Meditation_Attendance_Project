package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"registrations"}, allowSetters = true)
    private List<CourseOffering> courseOfferings = new ArrayList<>();

    public void addCourseOffering(CourseOffering courseOffering) {
        courseOffering.setCourse(this);
        courseOfferings.add(courseOffering);
    }

    public Course(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
