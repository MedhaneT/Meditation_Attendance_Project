package edu.miu.cs544.group1.project.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import edu.miu.cs544.group1.project.domain.*;
import edu.miu.cs544.group1.project.repository.AttendaceRecordRepository;
import edu.miu.cs544.group1.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@Transactional
public class AttendanceRecordImpl implements AttendanceRecordService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AttendaceRecordRepository attendaceRecordRepository;


    @Override
    public String barcodeReader(String barcode) throws ChecksumException, NotFoundException, FormatException, IOException {

        InputStream barCodeInputStream = new FileInputStream(barcode);
        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        Result result = reader.decode(bitmap);

        return result.getText();

    }

    @Override
    public void saveAttendance(String barcode, Location location) throws ChecksumException, NotFoundException, IOException, FormatException {
        String sourceBarcode = barcodeReader(barcode);
        Student student = studentRepository.findByBarcodeId(sourceBarcode).orElseThrow(() -> new RuntimeException("Not found by barcodeid"));

//        ClassSession classSession = classSessionService.findByLocalionAndTimeSlot(
//                location, timeSlotService.getCurrentTimeSlot());
//
//        AttendanceRecord attendanceRecord = new AttendanceRecord(
//                LocalDateTime.now(), student, classSession);
//        attendaceRecordRepository.save(attendanceRecord);
    }
}
