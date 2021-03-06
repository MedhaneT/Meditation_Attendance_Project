package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findStudentById(String sId);

    Optional<Student> findStudentByBarcodeId(String bId);

    void createStudent(StudentDto studentDto);

    void removeStudent(Long id);
}
