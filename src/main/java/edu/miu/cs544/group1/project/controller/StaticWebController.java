package edu.miu.cs544.group1.project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StaticWebController {
    @GetMapping("/")
    public RedirectView homePage() {
        return new RedirectView("/index.html");
    }
}
