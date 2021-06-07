package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Person;
import lombok.Getter;

@Getter
public class PersonDto {
    private Integer id;
    private String firstName;
    private String lastName;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }
}
