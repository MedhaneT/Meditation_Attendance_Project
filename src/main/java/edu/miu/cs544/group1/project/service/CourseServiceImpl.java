package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Course;
import edu.miu.cs544.group1.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return courseRepository.findByCode(code);
    }

    @Override
    public void createCource(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void removeCource(Long id) {
        courseRepository.deleteById(id);
    }
    
    
//     @Autowired
//     private CourseRepository repository;

//     @Override
//     public List<Course> findAll() {
//         return repository.findAll();
//     }
}
