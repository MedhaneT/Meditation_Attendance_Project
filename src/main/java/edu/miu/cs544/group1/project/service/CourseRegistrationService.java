package edu.miu.cs544.group1.project.service;


import edu.miu.cs544.group1.project.controller.dto.RegistrationDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.domain.Registration;

import java.util.List;

public interface CourseRegistrationService {
    List<RegistrationDto> findByCurrentUser();
}
