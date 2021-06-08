package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import edu.miu.cs544.group1.project.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }

    @Override
    public Optional<TimeSlot> findTimeSlotById(Long id) {

        return timeSlotRepository.findById(id);
    }

    @Override
    public Optional<TimeSlot> findTimeSlotByAbbreviation(String abbreviation) {
        return timeSlotRepository.findByAbbreviation(abbreviation);
    }

    @Override
    public void createTimeSlot(TimeSlotDto timeSlotDto) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setAbbreviation(timeSlotDto.getAbbreviation());
        timeSlot.setDescription(timeSlotDto.getDescription());
        //10:15
//        String startTime = timeSlotDto.getStartTime();
//        int sHour = Integer.parseInt(startTime.substring(0, 2));
//        int sMinute = Integer.parseInt(startTime.substring(3));
        timeSlot.setStartTime(timeSlotDto.getStartTime());
//
//        String endTime = timeSlotDto.getEndTime();
//        int eHour = Integer.parseInt(endTime.substring(0, 2));
//        int eMinute = Integer.parseInt(endTime.substring(3));
        timeSlot.setEndTime(timeSlotDto.getEndTime());

        timeSlotRepository.save(timeSlot);


    }

    @Override
    public void removeTimeSlot(Long id) {
        timeSlotRepository.deleteById(id);
    }
}
