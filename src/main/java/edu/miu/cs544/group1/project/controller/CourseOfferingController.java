package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.CourseOfferingDto;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courseOfferings")
public class CourseOfferingController {

    @Autowired
    CourseOfferingService courseOfferingService;

    @GetMapping
    public List<CourseOffering> findAll() {

        return courseOfferingService.findAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody CourseOfferingDto courseOfferingDto) {
//        courseOfferingService.findById(courseOfferingDto.getCid()).ifPresent((v)->{
//            throw new RuntimeException();
//        });
//
        courseOfferingService.createCourseOffering(courseOfferingDto);
    }
}
