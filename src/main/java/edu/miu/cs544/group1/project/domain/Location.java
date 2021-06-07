package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Location {
    @Id
    private Integer id;

    private String description;
    private Integer capacity;


    public Location(Integer id, String description, Integer capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
    }
}
