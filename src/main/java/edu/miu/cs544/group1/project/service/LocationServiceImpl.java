package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> findAll() {

        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findByLocationName(String locationName) {
        return locationRepository.findByName(locationName);
    }

    @Override
    public Optional<Location> findByLocationId(Long id) {
        return locationRepository.findById(id);
    }



    @Override
    public void createLocation(LocationDto locationDto) {
        Location location=new Location();
        location.setCapacity(locationDto.getCapacity());
        location.setDescription(locationDto.getDescription());
        location.setName(locationDto.getName());

        locationRepository.save(location);


    }

    @Override
    public void removeLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
