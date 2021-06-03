package edu.miu.cs544.group1.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    private Integer id;

    private String description;
    private Integer capacity;
}
