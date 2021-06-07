package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.TimeSlot;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class TimeSlotDto {
    private  Integer id;
    private String abbreviation;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;

    public TimeSlotDto(TimeSlot timeSlot){
        this.id= timeSlot.getId();
      this.abbreviation = timeSlot.getAbbreviation();
      this.startTime = timeSlot.getStartTime();
      this.endTime = timeSlot.getEndTime();
      this.description = timeSlot.getDescription();
    }
}
