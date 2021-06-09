package edu.miu.cs544.group1.project.controller.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class CourseOfferingDto {
    private String startDate;
    private String endDate;
    private String courseCode;
    private Long facultyId;

    public CourseOfferingDto(String startDate, String endDate, String courseCode, Long facultyId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCode = courseCode;
        this.facultyId = facultyId;
    }


}
