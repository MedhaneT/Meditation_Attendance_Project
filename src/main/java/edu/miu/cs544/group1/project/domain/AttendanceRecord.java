package edu.miu.cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class AttendanceRecord {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private LocalDateTime scanTime;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private Student student;

    @ManyToOne
    @JoinColumn
    private ClassSession session;

    public AttendanceRecord(
            LocalDateTime scanTime, Student student, ClassSession session) {
        this.scanTime = scanTime;
        this.student = student;
        this.session = session;
    }

    public AttendanceRecord() {
        this.scanTime = LocalDateTime.now();
    }
}
