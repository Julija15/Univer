package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String homepage() {
        return "/index";
    }

    @GetMapping("/student/login")
    public String studentLogin() {
        return "/student/login";
    }

    @GetMapping("/teacher/login")
    public String teacherLogin() {
        return "/teacher/login";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "/admin/login";
    }

}
