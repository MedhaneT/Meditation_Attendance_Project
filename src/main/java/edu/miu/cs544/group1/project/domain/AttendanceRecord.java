package edu.miu.cs544.group1.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
