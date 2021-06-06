package edu.miu.cs544.group1.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class AttendanceRecord {
    @Id
    private Long id;
    @Column(nullable = false)
    private LocalDateTime scanTime;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private ClassSession session;

    public AttendanceRecord(LocalTime now, Student stud, ClassSession session) {

    }
}
