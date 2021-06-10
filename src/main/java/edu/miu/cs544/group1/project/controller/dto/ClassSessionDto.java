package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.ClassSession;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Value
public class ClassSessionDto {
    private LocalDate startDate;
    private Long courseOfferingId;
    private String locationName;
    private List<TimeSlotDto> timeSlots;

    public ClassSessionDto(
            LocalDate startDate, Long courseOfferingId, String location, List<TimeSlotDto> timeSlots) {
        this.startDate = startDate;
        this.courseOfferingId = courseOfferingId;
        this.locationName = location;
        this.timeSlots = timeSlots;
    }

    public ClassSessionDto(ClassSession session) {
        this.startDate = session.getStartDate();
        this.courseOfferingId = session.getCourseOffering().getId();
        this.locationName = session.getLocation().getName();
        this.timeSlots = new ArrayList<>();
        session.getTimeSlots().forEach(
                timeSlot -> this.timeSlots.add(new TimeSlotDto(timeSlot)));
    }
}
