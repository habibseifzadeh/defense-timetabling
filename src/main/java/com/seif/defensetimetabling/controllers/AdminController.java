package com.seif.defensetimetabling.controllers;

import com.seif.defensetimetabling.services.SemesterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String URL_PREFIX = "/admin";
    private SemesterService semesterService;

    public AdminController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("semesters", semesterService.findAll());
        return URL_PREFIX + "/index";
    }
}
