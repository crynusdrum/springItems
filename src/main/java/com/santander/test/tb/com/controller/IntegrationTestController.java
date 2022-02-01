package com.santander.test.tb.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationTestController {

    @GetMapping("/integrationTest")
    public String hello(@RequestParam(name = "name", defaultValue = "test") String name) {
        return String.format("Integration, %s", name);
    }
}
