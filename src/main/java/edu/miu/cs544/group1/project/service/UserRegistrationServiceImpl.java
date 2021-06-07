package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService{
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public List<Registration> findAll() {
        return userRegistrationRepository.findAll();
    }
}
