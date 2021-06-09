package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.ClassSessionDto;
import edu.miu.cs544.group1.project.domain.ClassSession;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import edu.miu.cs544.group1.project.repository.ClassSessionRepository;
import edu.miu.cs544.group1.project.repository.CourseOfferingRepository;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import edu.miu.cs544.group1.project.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClassSessionServiceImpl implements ClassSessionService {

    @Autowired
    ClassSessionRepository classSessionRepository;
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    CourseOfferingRepository courseOfferingRepository;


    @Override
    public List<ClassSession> findAll() {
        return classSessionRepository.findAll();
    }

    @Override
    public Optional<ClassSession> findById(Long id) {
        return classSessionRepository.findById(id);
    }

    @Override
    public void createClassSession(ClassSessionDto classSessionDto) {
        ClassSession classSession = new ClassSession();

        String startDate = classSessionDto.getStartDate();
        int sYear = Integer.parseInt(startDate.substring(0, 4));
        int sMonth = Integer.parseInt(startDate.substring(5, 7));
        int sDay = Integer.parseInt(startDate.substring(8));
        classSession.setStartDate(LocalDate.of(sYear, sMonth, sDay));

        Optional<Location> location = locationRepository.findByName(classSessionDto.getLocationName());
        Location location1 = location.orElseThrow(() -> new IllegalArgumentException("Location Not Found"));
        classSession.setLocation(location1);

        Optional<TimeSlot> timeSlot = timeSlotRepository.findByAbbreviation(classSessionDto.getTimeSlot());
        TimeSlot timeSlot1 = timeSlot.orElseThrow(() -> new IllegalArgumentException("TimeSlot Not Found"));
        classSession.addTimeSlot(timeSlot1);

        Optional<CourseOffering> courseOffering = courseOfferingRepository.findById(classSessionDto.getCourseOfferingId());
        CourseOffering courseOffering1 = courseOffering.orElseThrow(() -> new IllegalArgumentException("Courseoffering Not Found"));
        classSession.setCourseOffering(courseOffering1);
        courseOffering1.addClassSession(classSession);

        classSessionRepository.save(classSession);


    }

    @Override
    public void removeClassSession(Long id) {
        classSessionRepository.deleteById(id);
    }

    @Override
    public Optional<ClassSession> findByLocationAndTimeSlot(Location location, TimeSlot timeSlot) {
        return classSessionRepository.findTodayClassSessionByLocationAndTimeSlot(location, timeSlot);
    }
}
