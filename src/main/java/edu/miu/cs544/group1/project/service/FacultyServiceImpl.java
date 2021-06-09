package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Faculty;
import edu.miu.cs544.group1.project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facutyRepository;


    @Override
    public List<Faculty> findAll() {
        return facutyRepository.findAll();
    }

    @Override
    public Optional<Faculty> findById(Long fId) {
        return facutyRepository.findById(fId);
    }

    @Override
    public void removeFaculty(Long id) {
        facutyRepository.deleteById(id);
    }
}
