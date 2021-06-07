package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @GetMapping("/userRegistrations")
    public List<Registration> findAll(){
        return courseRegistrationService.findAll();
    }
}
