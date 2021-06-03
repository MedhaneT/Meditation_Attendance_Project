package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Course {
    @Id
    private Integer id;
    private String code;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course")
    private List<CourseOffering> courseOfferings;
}
