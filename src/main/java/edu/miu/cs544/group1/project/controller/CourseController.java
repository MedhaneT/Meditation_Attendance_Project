package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

//    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private CourseRepository repository;

    @GetMapping
    public List<Course> findAll() {

        return repository.findAll();
    }



    @PostMapping
    public Course create(@Valid @RequestBody Course course) {
        repository.findByCode(course.getCode()).ifPresent((v) -> {
            throw new RuntimeException();
        });
        return repository.save(course);
    }
}
