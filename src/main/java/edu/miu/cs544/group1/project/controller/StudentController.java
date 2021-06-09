package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> findAll() {

        return studentService.findAll();
    }


    @PostMapping
    public void create(@Valid @RequestBody StudentDto studentDto) {
        studentService.findStudentById(studentDto.getStudentId()).ifPresent((v) -> {
            throw new RuntimeException();
        });

        studentService.createStudent(studentDto);
    }
}
