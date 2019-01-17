package com.seif.defensetimetabling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String URL_PREFIX = "/admin";

    @GetMapping({"", "/", "/index"})
    public String getIndex() {

        return URL_PREFIX + "/index";
    }
}
