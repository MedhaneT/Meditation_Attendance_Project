package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Person;
import edu.miu.cs544.group1.project.domain.User;
import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import lombok.Value;

@Value
public class RegisterUserDto {
    private String email;
    private String password;
    private Person person;
    private RoleCode roleCode;
}
