package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.CourseDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import edu.miu.cs544.group1.project.service.CourseService;
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
    private CourseService courseService;

    @GetMapping
    public List<Course> findAll() {

        return courseService.findAll();
    }



    @PostMapping
    public void create(@Valid @RequestBody CourseDto courseDto) {
           courseService.findByCode(courseDto.getCode()).ifPresent((v)->{
               throw new RuntimeException();
           });

        courseService.createCource(courseDto);
    }
}
