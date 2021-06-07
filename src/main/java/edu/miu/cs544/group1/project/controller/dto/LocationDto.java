package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Location;
import lombok.Getter;

@Getter
public class LocationDto {
    private Integer id;
    private String description;
    private Integer capacity;

    public LocationDto(Location location){
        this.id=location.getId();
        this.description = location.getDescription();
        this.capacity = location.getCapacity();
    }
}
