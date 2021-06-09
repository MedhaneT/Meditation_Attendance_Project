package edu.miu.cs544.group1.project.controller;


import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import edu.miu.cs544.group1.project.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/barcode")
public class AttendaceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;
    private LocationRepository locationRepository;

    @PostMapping("/{barcodeLocation}/{barcodeString}")
    public void barcodeAttedance(
            @PathVariable(name = "barcodeLocation") String barcodeLocation,
            @PathVariable(name = "barcodeString") String barcodeString) throws ChecksumException, NotFoundException, IOException, FormatException {
        Location location = locationRepository.findByName(barcodeLocation)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        attendanceRecordService.saveAttendance(barcodeString, location);
    }
}
