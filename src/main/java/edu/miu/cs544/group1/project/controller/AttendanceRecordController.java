package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.AttendanceRecordDto;
import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import edu.miu.cs544.group1.project.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendances")
public class AttendanceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @GetMapping
    public List<AttendanceRecord> findAll() {

        return attendanceRecordService.findAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody AttendanceRecordDto attendanceRecordDto) {
        attendanceRecordService.findByAttendanceScanTime(attendanceRecordDto.getScanTime()).ifPresent((v)->{
            throw new RuntimeException();
        });
        attendanceRecordService.createAttendanceRecord(attendanceRecordDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendanceRecord(@PathVariable long id){
        attendanceRecordService.removeAttendanceRecord(id);
    }

}
