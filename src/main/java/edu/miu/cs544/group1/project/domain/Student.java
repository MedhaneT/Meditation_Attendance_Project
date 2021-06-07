package edu.miu.cs544.group1.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "registrations")
@Component
public class Student extends Person {

    private String studentId;
    private String barcodeId;

    @OneToMany(mappedBy = "student")
    private Collection<Registration> registrations = new ArrayList<>();

    public Student(String firstName, String lastName, String studentId, String barcodeId) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.barcodeId = barcodeId;
    }


}
