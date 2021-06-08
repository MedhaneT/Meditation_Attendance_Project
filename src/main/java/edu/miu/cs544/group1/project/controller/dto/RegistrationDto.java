package edu.miu.cs544.group1.project.controller.dto;

import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Data
@Value
public class RegistrationDto {
    private String rid;
    private LocalDateTime registrationTime;
    private String studentId;
    private Long courseOfferingId;

    public RegistrationDto(String rid, String studentId, Long courseOfferingId) {
        this.rid = rid;
        this.studentId = studentId;
        this.courseOfferingId = courseOfferingId;
        this.registrationTime = LocalDateTime.now();
    }
}
