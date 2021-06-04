package edu.miu.cs544.group1.project.controller.dto;

import lombok.Value;

@Value
public class LoginRequestDto {
    private String email;
    private String password;
}
