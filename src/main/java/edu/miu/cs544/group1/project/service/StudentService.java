package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    public void findStudentbyBarcode(String barcode);
}
