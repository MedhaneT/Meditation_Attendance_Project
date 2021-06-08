package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.TimeSlot;
import lombok.Data;
import lombok.Value;

import java.time.LocalTime;

@Data
@Value
public class TimeSlotDto {
    private String abbreviation;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;

//    public TimeSlotDto(String abbreviation, String startTime, String endTime, String description) {
//        this.abbreviation = abbreviation;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.description = description;
//    }

    public TimeSlotDto(TimeSlot timeSlot) {
        //  this.id= timeSlot.getId();
        this.abbreviation = timeSlot.getAbbreviation();
        this.startTime = timeSlot.getStartTime();
        this.endTime = timeSlot.getEndTime();
        this.description = timeSlot.getDescription();
    }
}
