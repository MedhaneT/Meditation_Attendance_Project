package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.config.JPAUserDetails;
import edu.miu.cs544.group1.project.domain.Role;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class UserDataDto {
    private String fullName;
    private String email;
    private Set<String> roles;

    public UserDataDto(JPAUserDetails userDetails) {
        this.fullName = userDetails.getFirstName() + " " + userDetails.getLastName();
        this.email = userDetails.getEmail();
        this.roles = userDetails.getRoles().stream().map(role -> role.getCode().name()).collect(Collectors.toSet());
    }
}