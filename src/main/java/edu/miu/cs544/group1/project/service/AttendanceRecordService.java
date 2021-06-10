package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.AttendanceRecordDto;
import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.domain.Location;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AttendanceRecordService {
    void saveAttendance(String barcode, Location location);

    void createAttendanceRecord(AttendanceRecordDto attendanceRecordDto);

    Optional<AttendanceRecord> findById(Long id);

    Optional<AttendanceRecord> findByAttendanceScanTime(LocalDateTime scanTime);

    List<AttendanceRecord> findAll();

    List<AttendanceRecordDto> findByCourseOffering(CourseOffering courseOffering);

    List<AttendanceRecordDto> findByCourseOfferings(List<CourseOffering> courseOfferings);

    void removeAttendanceRecord(Long id);

}
