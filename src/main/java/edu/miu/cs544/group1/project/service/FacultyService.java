package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    List<Faculty> findAll();

    Optional<Faculty> findById(Long fId);

    //  void createFaculty(Faculty Faculty);
    void removeFaculty(Long id);

}
