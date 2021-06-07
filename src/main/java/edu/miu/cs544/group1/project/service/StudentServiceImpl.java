package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.StudentDto;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private Student student;

    Student stud = new Student("behane", "Teklehaimanot", "123455", "/home/berhane/Desktop/barcode.png");

    @Override
    public List<StudentDto> findAll() {
        return repository.findAll().stream().map(student -> new StudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public void findStudentbyBarcode(String barcode) {

        if (barcode == stud.getBarcodeId())
            ;
        System.out.println("present");

        System.out.println("absent");

    }

}
