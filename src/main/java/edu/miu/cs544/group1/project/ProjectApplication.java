package edu.miu.cs544.group1.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
    }

}
