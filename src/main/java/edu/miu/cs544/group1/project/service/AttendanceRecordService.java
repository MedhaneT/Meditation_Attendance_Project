package edu.miu.cs544.group1.project.service;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import edu.miu.cs544.group1.project.controller.dto.AttendanceRecordDto;
import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import edu.miu.cs544.group1.project.domain.Location;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AttendanceRecordService {
    void saveAttendance(String barcode, Location location);

    void createAttendanceRecord(AttendanceRecordDto attendanceRecordDto);

    Optional<AttendanceRecord> findById(Long id);

    Optional<AttendanceRecord> findByAttendanceScanTime(LocalDateTime scanTime);

    List<AttendanceRecord> findAll();

    void removeAttendanceRecord(Long id);

}
