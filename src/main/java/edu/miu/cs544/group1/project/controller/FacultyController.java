package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.domain.Faculty;
import edu.miu.cs544.group1.project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

         @Autowired
         FacultyService facultyService;

    @GetMapping
    public List<Faculty> findAll() {

        return facultyService.findAll();
    }


//
//    @PostMapping
//    public void create(@Valid @RequestBody CourseDto courseDto) {
//        courseService.findByCode(courseDto.getCode()).ifPresent((v)->{
//            throw new RuntimeException();
//        });
//
//        courseService.createCource(courseDto);
//    }
}
