package com.flower.allFlowers.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class DefaultController {

    @GetMapping(value = "/")
    public String index() {
        return "login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";

    }
    @GetMapping("/error")
    public String error403() {
        return "error/error";
    }
}

