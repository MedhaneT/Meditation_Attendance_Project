package edu.miu.cs544.group1.project.controller.dto;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor
public class LoginRequestDto {
    private String email = null;
    private String password = null;
}
