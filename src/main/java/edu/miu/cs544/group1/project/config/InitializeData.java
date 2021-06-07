package edu.miu.cs544.group1.project.config;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.*;
import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import edu.miu.cs544.group1.project.repository.LocationRepository;
import edu.miu.cs544.group1.project.repository.RoleRepository;
import edu.miu.cs544.group1.project.repository.UserRepository;
import edu.miu.cs544.group1.project.service.LocationService;
import edu.miu.cs544.group1.project.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class InitializeData {
    @Bean
    public CommandLineRunner loadData(
            RoleRepository repository, UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder, LocationRepository locationRepository, LocationService locationService) {
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
            Person person = new Student();

            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "medhane@gmail.com",
                        passwordEncoder.encode("123123"),
                        new Student("Medhane", "TS", "11111", "000-111222"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "brhin@gmail.com",
                        passwordEncoder.encode("222222"),
                        new Student("Brhane", "Dk", "11112", "000-222333"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "misgna@gmail.com",
                        passwordEncoder.encode("333333"),
                        new Student("Misgna", "KK", "11113", "000-333444"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "Teddy@gmail.com",
                        passwordEncoder.encode("444444"),
                        new Student("Teddy", "SS", "11114", "000-444555"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "Bob@gmail.com",
                        passwordEncoder.encode("444444"),
                        new Student("Bob", "DD", "11115", "000-555666"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "john@gmail.com",
                        passwordEncoder.encode("555555"),
                        new Student("John", "Dow", "11116", "000-677766"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "mohamed@gmail.com",
                        passwordEncoder.encode("672456"),
                        new Student("Mohammed", "Beshir", "11117", "000-777888"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "sam@gmail.com",
                        passwordEncoder.encode("672456"),
                        new Student("Sam", "Mm", "11118", "000-888999"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "isabella@gmail.com",
                        passwordEncoder.encode("678756"),
                        new Student("Isabella", "Jocob", "11119", "000-999000"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "will@gmail.com",
                        passwordEncoder.encode("678906"),
                        new Student("William", "Alex", "11120", "000-999111"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto(
                        "zoe@gmail.com",
                        passwordEncoder.encode("678906"),
                        new Student("Hailey", "Caleb", "11121", "000-999222"),
                        RoleCode.STUDENT);
                userService.registerUser(userDto);
            }

            {
                LocationDto location = new LocationDto(
                     new Location(1,"VaryHoll",50)

                );
                locationService.registerLocation(location);
            }
            {
                LocationDto location = new LocationDto(
                        new Location(2,"Mclaughlin",45)
                );
                locationService.registerLocation(location);
            }
            {
                LocationDto location = new LocationDto(
                        new Location(3,"Argiro",60)
                );
                locationService.registerLocation(location);
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
        };
    }
}