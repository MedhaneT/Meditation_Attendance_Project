package edu.miu.cs544.group1.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private Integer id;

    private String description;
    private Integer capacity;



}
