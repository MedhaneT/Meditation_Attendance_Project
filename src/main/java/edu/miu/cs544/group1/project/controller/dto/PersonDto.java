package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PersonDto {
    protected Long id;
    protected String firstName;
    protected String lastName;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    public PersonDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
