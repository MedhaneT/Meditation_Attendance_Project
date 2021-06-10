package edu.miu.cs544.group1.project.controller.dto;

import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Data
@Value
public class AttendanceRecordDto {

    private LocalDateTime scanTime;
    private StudentDto student;
    private ClassSessionDto classSession;

    public AttendanceRecordDto(
            AttendanceRecord attendanceRecord) {
        this.student = new StudentDto(attendanceRecord.getStudent());
        this.classSession = new ClassSessionDto(attendanceRecord.getSession());
        this.scanTime = LocalDateTime.now();
    }
}
