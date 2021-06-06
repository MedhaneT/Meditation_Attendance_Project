package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.User;

public interface UserService {
    User registerUser(RegisterUserDto registerUserDto);
}
