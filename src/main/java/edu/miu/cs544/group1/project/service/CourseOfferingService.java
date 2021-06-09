package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.CourseOfferingDto;
import edu.miu.cs544.group1.project.domain.CourseOffering;

import java.util.List;
import java.util.Optional;

public interface CourseOfferingService {

    List<CourseOffering> findAll();

    Optional<CourseOffering> findById(Long id);

    // Optional<CourseOffering> findBy(String courseName);
    void createCourseOffering(CourseOfferingDto courseOfferingDto);

    void removeCourseOffering(Long id);
}
