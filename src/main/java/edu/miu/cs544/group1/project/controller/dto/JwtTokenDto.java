package edu.miu.cs544.group1.project.controller.dto;

import lombok.Value;

@Value
public class JwtTokenDto {
    private String accessToken;
    private UserDataDto userData;
}