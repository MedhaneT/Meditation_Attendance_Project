package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import edu.miu.cs544.group1.project.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TimeSlotServiceImpl implements  TimeSlotService{

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public List<TimeSlotDto> findAll() {
        return timeSlotRepository.findAll().stream().map(t->new TimeSlotDto(t)).collect(Collectors.toList());
    }

    @Override
    public TimeSlot registerTimeSlot(TimeSlotDto timeSlotDto) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setId(timeSlotDto.getId());
        timeSlot.setAbbreviation(timeSlotDto.getAbbreviation());
        timeSlot.setStartTime(timeSlotDto.getStartTime());
        timeSlot.setEndTime(timeSlotDto.getEndTime());
        timeSlot.setDescription(timeSlotDto.getDescription());

        timeSlot = timeSlotRepository.save(timeSlot);

        return timeSlot;
    }
}
