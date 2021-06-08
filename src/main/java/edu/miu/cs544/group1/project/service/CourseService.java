package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.CourseDto;
import edu.miu.cs544.group1.project.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();

    Optional<Course> findById(Long id);

    Optional<Course> findByCode(String name);

    void createCource(CourseDto courseDto);

    void removeCource(Long id);

}
