package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Faculty extends Person {
    public Faculty(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
