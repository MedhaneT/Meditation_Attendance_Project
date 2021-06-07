package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseService {
     // creat
    // read
    // update
    // delete

    List<Course> findAll();
    Optional<Course> findById(Long id );
    Optional<Course> findByCode(String name);
    void createCource(Course course);
    void removeCource(Long id);
    
    
    
    //List<Course> findAll();
}
