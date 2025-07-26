package com.bogazici.athleticsteam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("athlete")
public class AthleteController {
    @GetMapping("/helloGet")
    public String helloGet() {
        return "Hello World";
    }

    @PostMapping("/helloPost")
    public String helloPost() {
        return "Hello World";
    }
}
