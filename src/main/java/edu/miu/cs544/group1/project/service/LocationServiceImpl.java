package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location registerLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setCapacity(locationDto.getCapacity());
        location.setDescription(locationDto.getDescription());

        location = locationRepository.save(location);
        return location;
    }

    @Override
    public List<LocationDto> findAll() {
        return locationRepository.findAll().stream().map(Location -> new LocationDto(Location)).collect(Collectors.toList());
    }
}
