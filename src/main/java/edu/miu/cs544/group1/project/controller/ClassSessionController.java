package edu.miu.cs544.group1.project.controller;


import edu.miu.cs544.group1.project.controller.dto.ClassSessionDto;
import edu.miu.cs544.group1.project.domain.ClassSession;
import edu.miu.cs544.group1.project.service.ClassSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classSessions")
public class ClassSessionController {

    @Autowired
    ClassSessionService classSessionService;

    @GetMapping
    public List<ClassSession> findAll() {

        return classSessionService.findAll();
    }



    @PostMapping
    public void create(@Valid @RequestBody ClassSessionDto classSessionDto) {
//        classSessionService.findById(classSessionDto.getSid()).ifPresent((v)->{
//            throw new RuntimeException();
//        });

        classSessionService.createClassSession(classSessionDto);
    }
}
