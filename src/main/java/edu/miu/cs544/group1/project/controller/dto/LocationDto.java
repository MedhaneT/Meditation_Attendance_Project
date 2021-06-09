package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Location;
import lombok.Data;
import lombok.Value;

@Data
@Value
public class LocationDto {
    private Integer id;
    private String name;
    private String description;
    private Integer capacity;

    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.description = location.getDescription();
        this.capacity = location.getCapacity();
    }

    public LocationDto(String name, String description, Integer capacity) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }
}
