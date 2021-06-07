package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<LocationDto> findAll(){
        return locationService.findAll();
    }
}
