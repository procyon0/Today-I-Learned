package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapleController {
    @GetMapping("test")
    public String goTest() {
        return "test";
    }

}
