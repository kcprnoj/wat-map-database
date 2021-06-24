package com.watmap.server.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String addFaculty(){
        return "Main";
    }
}
