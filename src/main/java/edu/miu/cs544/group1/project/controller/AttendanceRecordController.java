package edu.miu.cs544.group1.project.controller;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import edu.miu.cs544.group1.project.controller.dto.AttendanceRecordDto;
import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import edu.miu.cs544.group1.project.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<AttendanceRecord> findAll() {

        return attendanceRecordService.findAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody AttendanceRecordDto attendanceRecordDto) {
        attendanceRecordService.findByAttendanceScanTime(attendanceRecordDto.getScanTime()).ifPresent((v) -> {
            throw new RuntimeException();
        });
        attendanceRecordService.createAttendanceRecord(attendanceRecordDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendanceRecord(@PathVariable long id) {
        attendanceRecordService.removeAttendanceRecord(id);
    }

    @PostMapping("/{barcodeLocation}/{barcodeString}")
    public void barcodeAttedance(
            @PathVariable(name = "barcodeLocation") String barcodeLocation,
            @PathVariable(name = "barcodeString") String barcodeString) throws ChecksumException, NotFoundException, IOException, FormatException {
        Location location = locationRepository.findByName(barcodeLocation)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        attendanceRecordService.saveAttendance(barcodeString, location);
    }

}
