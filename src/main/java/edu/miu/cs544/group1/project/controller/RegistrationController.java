package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.controller.dto.RegistrationDto;
import edu.miu.cs544.group1.project.domain.Registration;
import edu.miu.cs544.group1.project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @GetMapping
    public List<Registration> findAll() {

        return registrationService.findAll();
    }


    @PostMapping
    public void create(@Valid @RequestBody RegistrationDto registrationDto) {
//        registrationService.findRegistrationById(registrationDto.getRid()).ifPresent((v) -> {
//            throw new RuntimeException();
//        });

        registrationService.createRegistration(registrationDto);
    }
}
