package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.domain.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlotDto> findAll();
    TimeSlot registerTimeSlot(TimeSlotDto timeSlotDto);
}
