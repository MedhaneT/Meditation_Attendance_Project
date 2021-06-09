package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.ClassSessionDto;
import edu.miu.cs544.group1.project.domain.ClassSession;

import java.util.List;
import java.util.Optional;

public interface ClassSessionService {
    List<ClassSession> findAll();

    Optional<ClassSession> findById(Long id);

    void createClassSession(ClassSessionDto classSessionDto);

    void removeClassSession(Long id);

}
