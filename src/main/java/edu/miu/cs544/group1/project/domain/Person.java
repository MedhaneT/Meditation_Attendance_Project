package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
@NoArgsConstructor
public abstract class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn
    private User user;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
