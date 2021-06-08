package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.CourseDto;
import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface LocationService {
    List<Location> findAll();
    Optional<Location> findByLocationName(String locationName );
    Optional<Location> findByLocationId(Long id );
    void createLocation(LocationDto locationDto);
    void removeLocation(Long id);
}
