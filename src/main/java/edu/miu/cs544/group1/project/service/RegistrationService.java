package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.RegistrationDto;
import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.domain.Student;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
    List<Registration> findAll();
//    Optional<Registration> findRegistrationById(String sId);

    void createRegistration(RegistrationDto registrationDto);
    void removeRegistration(Long id);
}
