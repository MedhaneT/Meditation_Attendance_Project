package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime registrationTime;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"user", "registrations"}, allowSetters = true)
    private Student student;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"sessions", "faculty", "registrations"}, allowSetters = true)
    private CourseOffering courseOffering;
}
