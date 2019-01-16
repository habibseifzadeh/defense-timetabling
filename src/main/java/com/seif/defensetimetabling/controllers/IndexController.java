package com.seif.defensetimetabling.controllers;

import com.seif.defensetimetabling.services.DefenseSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private DefenseSessionService defenseSessionService;

    public IndexController(DefenseSessionService defenseSessionService) {
        this.defenseSessionService = defenseSessionService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {

        //TODO defense sessions must be sorted based on date and time

        model.addAttribute("defenseSessions", defenseSessionService.findAll());

        return "index";
    }
}
