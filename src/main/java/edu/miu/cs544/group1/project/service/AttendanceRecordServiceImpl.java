package edu.miu.cs544.group1.project.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import edu.miu.cs544.group1.project.controller.dto.AttendanceRecordDto;
import edu.miu.cs544.group1.project.domain.*;
import edu.miu.cs544.group1.project.repository.AttendanceRecordRepository;
import edu.miu.cs544.group1.project.repository.ClassSessionRepository;
import edu.miu.cs544.group1.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService {

    @Autowired
    AttendanceRecordRepository attendanceRecordRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassSessionRepository classSessionRepository;

    @Autowired
    private ClassSessionService classSessionService;

    @Autowired
    private TimeSlotService timeSlotService;

    //   @Override
//    public String barcodeReader(String barcode) throws ChecksumException, NotFoundException, FormatException, IOException {
//
//        InputStream barCodeInputStream = new FileInputStream(barcode);
//        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
//
//        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
//        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//        Reader reader = new MultiFormatReader();
//        Result result = reader.decode(bitmap);
//
//        return result.getText();
//
//    }

    @Override
    public void saveAttendance(String barcode, Location location) {
        Student student = studentRepository.findByBarcodeId(barcode).orElseThrow(() -> new RuntimeException("Not found by barcodeid"));

        ClassSession classSession = classSessionService.findByLocationAndTimeSlot(
                location, timeSlotService.getTimeSlot(LocalTime.now()).get()).get();

        AttendanceRecord attendanceRecord = new AttendanceRecord(
                LocalDateTime.now(), student, classSession);
        attendanceRecordRepository.save(attendanceRecord);
    }

    @Override
    public void createAttendanceRecord(AttendanceRecordDto attendanceRecordDto) {
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        LocalDateTime scanTime = attendanceRecordDto.getScanTime();
        attendanceRecord.setScanTime(scanTime);
        Optional<Student> student = studentRepository.findByBarcodeId(
                attendanceRecordDto.getStudent().getBarcodeId());
        Student student1 = student.orElseThrow(() -> new UsernameNotFoundException("Student Not Found"));
        attendanceRecord.setStudent(student1);

        Collection<Registration> registrations = student1.getRegistrations();
        for (Registration registration : registrations) {
            CourseOffering courseOffering = registration.getCourseOffering();
            if (scanTime.toLocalDate().compareTo(courseOffering.getStartDate()) > 0 && scanTime.toLocalDate().compareTo(courseOffering.getEndDate()) < 0) {
                List<ClassSession> classSessions = courseOffering.getSessions();
                for (ClassSession classSession : classSessions) {
                    if (scanTime.toLocalDate().compareTo(classSession.getStartDate()) > 0) {
                        attendanceRecord.setSession(classSession);
                    }
                }


            }

        }
        attendanceRecordRepository.save(attendanceRecord);
    }

    @Override
    public Optional<AttendanceRecord> findById(Long id) {
        return attendanceRecordRepository.findById(id);
    }

    @Override
    public Optional<AttendanceRecord> findByAttendanceScanTime(LocalDateTime scanTime) {
        return attendanceRecordRepository.findByScanTime(scanTime);
    }

    @Override
    public List<AttendanceRecord> findAll() {
        return attendanceRecordRepository.findAll();
    }

    @Override
    public List<AttendanceRecordDto> findByCourseOffering(CourseOffering courseOffering) {
        List<AttendanceRecordDto> attendanceRecordDtos = new ArrayList<>();
        attendanceRecordRepository.findByCourseOffering(courseOffering)
                .forEach(attendanceRecord -> attendanceRecordDtos.add(new AttendanceRecordDto(attendanceRecord)));
        return attendanceRecordDtos;
    }

    @Override
    public List<AttendanceRecordDto> findByCourseOfferings(List<CourseOffering> courseOfferings) {
        List<AttendanceRecordDto> attendanceRecordDtos = new ArrayList<>();
        attendanceRecordRepository.findByCourseOfferings(courseOfferings)
                .forEach(attendanceRecord -> attendanceRecordDtos.add(new AttendanceRecordDto(attendanceRecord)));
        return attendanceRecordDtos;
    }

    @Override
    public void removeAttendanceRecord(Long id) {
        attendanceRecordRepository.deleteById(id);
    }
}
