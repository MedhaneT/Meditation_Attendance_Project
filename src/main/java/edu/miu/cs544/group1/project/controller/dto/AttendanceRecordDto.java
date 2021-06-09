package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.ClassSession;
import edu.miu.cs544.group1.project.domain.Student;
import lombok.Data;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Value
public class AttendanceRecordDto {

    private LocalDateTime scanTime;

    private String studentBarCodeId;




    public AttendanceRecordDto(String studentBarCodeId, String sessionId) {
        this.studentBarCodeId= studentBarCodeId;
        this.scanTime=LocalDateTime.now();
    }
}
