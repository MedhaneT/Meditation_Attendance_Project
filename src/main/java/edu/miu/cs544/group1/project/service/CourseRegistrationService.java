package edu.miu.cs544.group1.project.service;


import edu.miu.cs544.group1.project.domain.Registration;

import java.util.List;

public interface CourseRegistrationService {
    List<Registration> findAll();
}
