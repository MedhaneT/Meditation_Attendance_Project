package edu.miu.cs544.group1.project.controller.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ClassSessionDto {
    private String startDate;
    private Long courseOfferingId;
    private String locationName;
    private String timeSlot;

    public ClassSessionDto(String startDate, Long courseOfferingId, String location, String timeSlot) {
        this.startDate = startDate;
        this.courseOfferingId = courseOfferingId;
        this.locationName = location;
        this.timeSlot = timeSlot;
    }
}
