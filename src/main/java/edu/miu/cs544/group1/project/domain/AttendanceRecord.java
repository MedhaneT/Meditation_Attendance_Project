package edu.miu.cs544.group1.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime scanTime;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private ClassSession session;

    public AttendanceRecord(LocalDateTime scanTime, Student student, ClassSession session) {
        this.scanTime = scanTime;
        this.student = student;
        this.session = session;
    }

    public AttendanceRecord() {
        this.scanTime=LocalDateTime.now();
    }
}
