package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.domain.TimeSlot;

import java.util.List;
import java.util.Optional;

public interface TimeSlotService {
    List<TimeSlot> findAll();

    Optional<TimeSlot> findTimeSlotById(Long id);

    Optional<TimeSlot> findTimeSlotByAbbreviation(String abbreviation);

    void createTimeSlot(TimeSlotDto timeSlotDto);

    void removeTimeSlot(Long id);
}
