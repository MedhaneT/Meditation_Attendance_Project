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
    void saveAttendance(String barcode, Location location) throws ChecksumException, IOException, FormatException, NotFoundException;

    String barcodeReader(String barcode) throws ChecksumException, FormatException, IOException, NotFoundException;

    public void createAttendanceRecord(AttendanceRecordDto attendanceRecordDto);

    public Optional<AttendanceRecord> findById(Long id);

    public Optional<AttendanceRecord> findByAttendanceScanTime(LocalDateTime scanTime);

    public List<AttendanceRecord> findAll();

    public void removeAttendanceRecord(Long id);

}
