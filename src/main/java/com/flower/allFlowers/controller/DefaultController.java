package com.flower.allFlowers.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class DefaultController {
    @RequestMapping(value = "/home")
    public String home() {
        return "/home";
    }
    @RequestMapping(value = "/")
    public String index() {
        return "/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";

    }
    @GetMapping("/error")
    public String error403() {
        return "/error/error";
    }
}

