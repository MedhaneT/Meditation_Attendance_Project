package edu.miu.cs544.group1.project.service;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import edu.miu.cs544.group1.project.domain.Location;

import java.io.IOException;


public interface AttendaceRecordService {

    String barcodeReader(String barcode) throws ChecksumException, NotFoundException, FormatException, IOException;

    void saveAttendance(String barcode, Location location) throws ChecksumException, NotFoundException, IOException, FormatException;
}
