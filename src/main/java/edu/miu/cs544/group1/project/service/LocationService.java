package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.domain.Location;

import java.util.List;

public interface LocationService {
    Location registerLocation(LocationDto locationDto);
    List<LocationDto> findAll();
}
