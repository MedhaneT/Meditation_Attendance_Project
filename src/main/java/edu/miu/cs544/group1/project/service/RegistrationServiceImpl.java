package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.RegistrationDto;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.repository.CourseOfferingRepository;
import edu.miu.cs544.group1.project.repository.RegistrationRepository;
import edu.miu.cs544.group1.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseOfferingRepository courseOfferingRepository;


    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

//    @Override
//    public Optional<Registration> findRegistrationById(String sId) {
//        return registrationRepository.findByRid(sId);
//    }

    @Override
    public void createRegistration(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        registration.setRegistrationTime(registrationDto.getRegistrationTime());
        Optional<Student> student = studentRepository.findByStudentId(registrationDto.getStudentId());
        Student student1 = student.orElseThrow(() -> new UsernameNotFoundException("Student Not found"));

        registration.setStudent(student1);

        Optional<CourseOffering> courseOffering = courseOfferingRepository.findById(registrationDto.getCourseOfferingId());
        CourseOffering courseOffering1 = courseOffering.orElseThrow(() -> new UsernameNotFoundException("CourseOffering Not Found"));
        registration.setCourseOffering(courseOffering1);

        student1.addRegistration(registration);
        courseOffering1.addRegistration(registration);

        registrationRepository.save(registration);

    }

    @Override
    public void removeRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
