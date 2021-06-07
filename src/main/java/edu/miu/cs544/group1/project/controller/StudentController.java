package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;

   @GetMapping
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable int id){
       return studentService.findById(id);
    }
}
