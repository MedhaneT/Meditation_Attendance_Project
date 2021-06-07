package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Student;
import lombok.Getter;

@Getter
public class StudentDto extends PersonDto{
    private String studentId;
    private String barcodeId;

    public StudentDto(Student person) {
        super(person);
        this.studentId = person.getStudentId();
        this.barcodeId = person.getBarcodeId();
    }
}
