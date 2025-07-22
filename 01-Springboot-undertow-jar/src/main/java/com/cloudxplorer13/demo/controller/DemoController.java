package com.cloudxplorer13.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String hello() {
        return "redirect:/index.html";
    }
}
