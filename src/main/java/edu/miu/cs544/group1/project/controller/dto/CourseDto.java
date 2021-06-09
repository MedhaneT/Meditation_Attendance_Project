package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.CourseOffering;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
public class CourseDto {

    private String code;
    private String name;
    private String description;

    public CourseDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
