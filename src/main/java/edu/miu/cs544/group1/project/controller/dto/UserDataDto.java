package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.config.JPAUserDetails;
import lombok.Value;

@Value
public class UserDataDto {
    private String fullName;
    private String email;

    public UserDataDto(JPAUserDetails userDetails) {
        this.fullName = userDetails.getFirstName() + " " + userDetails.getLastName();
        this.email = userDetails.getEmail();
    }
}