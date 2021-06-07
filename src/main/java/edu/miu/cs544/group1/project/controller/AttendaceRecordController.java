package edu.miu.cs544.group1.project.controller;


import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.service.AttendaceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/barcode")
public class AttendaceRecordController {

    @Autowired
    private AttendaceRecordService attendaceRecordService;

    @PostMapping("/{barcodeLocation}/{barcodeString}" )
    public void barcodeAttedance(
            @PathVariable(name = "barcodeLocation") String barcodeLocation,
            @PathVariable(name = "barcodeString") String barcodeString) throws ChecksumException, NotFoundException, IOException, FormatException {
//        Location location = locationService.findByCode(barcodeLocation);
//        attendaceRecordService.saveAttendance(barcodeString,location);
    }
}
