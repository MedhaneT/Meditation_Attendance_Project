package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.CourseDto;
import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping
    public List<Location> findAll() {

        return locationService.findAll();
    }



    @PostMapping
    public void create(@Valid @RequestBody LocationDto locationDto) {
        locationService.findByLocationName(locationDto.getName()).ifPresent((v)->{
            throw new RuntimeException();
        });

        locationService.createLocation(locationDto);
    }
}
