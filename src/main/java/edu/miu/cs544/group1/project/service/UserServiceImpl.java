package edu.miu.cs544.group1.project.service;

import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.Role;
import edu.miu.cs544.group1.project.domain.User;
import edu.miu.cs544.group1.project.repository.RoleRepository;
import edu.miu.cs544.group1.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setPerson(registerUserDto.getPerson());
        registerUserDto.getPerson().setUser(user);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findByCode(registerUserDto.getRoleCode()).get());
        user.setRoles(roleSet);

        user = userRepository.save(user);
        return user;
    }
}
