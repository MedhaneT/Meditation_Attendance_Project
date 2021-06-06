package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.User;

public interface UserService {
    // creat
    // read
    // update
    // delete

    List<Course> findAll();
    Optional<Course> findById(Long id );
    Optional<Course> findByCode(String name);
    void createCource(Course course);
    void removeCource(Long id);
    
    
    //User registerUser(RegisterUserDto registerUserDto);
}
