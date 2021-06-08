package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.CourseDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {

        return courseRepository.findById(id);
    }

    @Override
    public Optional<Course> findByCode(String code) {

        return courseRepository.findByCode(code);
    }

    @Override
    public void createCource(CourseDto courseDto) {
        Course course=new Course();
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        courseRepository.save(course);
    }

    @Override
    public void removeCource(Long id) {
        courseRepository.deleteById(id);
    }
    

}
