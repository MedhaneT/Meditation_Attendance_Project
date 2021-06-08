package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.CourseOfferingDto;
import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.domain.Faculty;
import edu.miu.cs544.group1.project.repository.CourseOfferingRepository;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import edu.miu.cs544.group1.project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }

    public Optional<CourseOffering> findById(Long id) {
        return courseOfferingRepository.findById(id);
    }

    @Override
    public void createCourseOffering(CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = new CourseOffering();
        String startDate = courseOfferingDto.getStartDate();
        int sYear = Integer.parseInt(startDate.substring(0, 4));
        int sMonth = Integer.parseInt(startDate.substring(5, 7));
        int sDay = Integer.parseInt(startDate.substring(8));
        courseOffering.setStartDate(LocalDate.of(sYear, sMonth, sDay));

        String endDate = courseOfferingDto.getEndDate();
        int eYear = Integer.parseInt(endDate.substring(0, 4));
        int eMonth = Integer.parseInt(endDate.substring(5, 7));
        int eDay = Integer.parseInt(endDate.substring(8));
        courseOffering.setEndDate(LocalDate.of(eYear, eMonth, eDay));

        String courseCode = courseOfferingDto.getCourseCode();
        Optional<Course> course = courseRepository.findByCode(courseCode);
        Course course1 = course.orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        courseOffering.setCourse(course1);
        course1.addCourseOffering(courseOffering);


        System.out.println("error in service above optional faculty");
        Optional<Faculty> faculty = facultyRepository.findById(courseOfferingDto.getFacultyId());
        System.out.println("error in service below optional faculty");
        Faculty faculty1 = faculty.orElseThrow(() -> new IllegalArgumentException("Faculty Not Fount"));
        courseOffering.setFaculty(faculty1);


        courseOfferingRepository.save(courseOffering);

    }

    @Override
    public void removeCourseOffering(Long id) {
        courseOfferingRepository.deleteById(id);
    }
}
