package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.domain.Student;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegistrationDto {

    private Long id;
    private LocalDateTime registrationTime;
    private Student student;
    private CourseOffering courseOffering;

    public RegistrationDto(Registration registration){
        this.id = registration.getId();
        this.registrationTime = registration.getRegistrationTime();
        this.student = registration.getStudent();
        this.courseOffering = registration.getCourseOffering();
    }
}
