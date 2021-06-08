package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.TimeSlotDto;
import edu.miu.cs544.group1.project.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping("timeSlots")
    public List<TimeSlotDto> findAll(){
        return timeSlotService.findAll();
    }

}
