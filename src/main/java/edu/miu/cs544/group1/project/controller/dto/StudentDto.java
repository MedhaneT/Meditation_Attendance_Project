package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.Student;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Getter
public class StudentDto extends PersonDto {
    private String studentId;
    private String barcodeId;

    public StudentDto(Student person) {
        super(person);
        this.studentId = person.getStudentId();
        this.barcodeId = person.getBarcodeId();
    }

    public StudentDto(String firstName, String lastName, String studentid, String barcodeid) {
        super(firstName, lastName);
        this.studentId = studentid;
        this.barcodeId = barcodeid;
    }
}
