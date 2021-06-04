package edu.miu.cs544.group1.project.config;

import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.Faculty;
import edu.miu.cs544.group1.project.domain.Role;
import edu.miu.cs544.group1.project.domain.Student;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import edu.miu.cs544.group1.project.repository.RoleRepository;
import edu.miu.cs544.group1.project.repository.TimeSlotRepository;
import edu.miu.cs544.group1.project.repository.UserRepository;
import edu.miu.cs544.group1.project.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;

@Configuration
@Log4j2
public class InitializeData {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Bean
    public CommandLineRunner loadData(
            RoleRepository repository, UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
        return (args) -> {
            userRepository.deleteAll();
            userRepository.deleteAll();
            repository.deleteAll();

            // save roles
            repository.save(new Role(RoleCode.ADMIN));
            repository.save(new Role(RoleCode.STUDENT));

            // fetch all roles
            log.info("Roles found with findAll():");
            log.info("--------------------------------------------------------------");
            for (Role role : repository.findAll()) {
                log.info(role.toString());
            }

            // add admin user
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "admin@miu.edu",
                        passwordEncoder.encode("123123"),
                        new Faculty("Payman", "Salek"),
                        RoleCode.ADMIN);
                userService.registerUser(userDto);
            }

            // add student user
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "tuannx87@gmail.com",
                        passwordEncoder.encode("123123"),
                        new Student("Xuan Tuan", "Nguyen", "000-666999", "000-666999"),
                        RoleCode.ADMIN);
                userService.registerUser(userDto);
            }

            log.info("Registered Users:");
            log.info("--------------------------------------------------------------");
            userRepository.findAll().forEach(
                    user1 -> {
                        log.info(user1);
                        JPAUserDetails userDetails = new JPAUserDetails(user1);
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
            );

            log.info("TimeSlots:");
            timeSlotRepository.save(new TimeSlot("AM", LocalTime.of(10, 0), LocalTime.of(12, 30), "Morning"));
            timeSlotRepository.save(new TimeSlot("PM", LocalTime.of(13, 30), LocalTime.of(16, 0), "Afternoon"));

            timeSlotRepository.findAll().forEach(System.out::println);
            log.info("Locations:");
        };
    }
}