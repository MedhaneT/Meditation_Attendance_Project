package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import edu.miu.cs544.group1.project.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/timeSlots")
public class TimeSlotController {

       @Autowired
       TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlot> findAll() {

        return timeSlotService.findAll();
    }



    @PostMapping
    public void create(@Valid @RequestBody TimeSlotDto timeSlotDto) {
        timeSlotService.findTimeSlotByAbbreviation(timeSlotDto.getAbbreviation()).ifPresent((v)->{
            throw new RuntimeException();
        });

        timeSlotService.createTimeSlot(timeSlotDto);
    }
}
