package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.services.StringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringController {

    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/append")
    public String append(@RequestParam String string1, @RequestParam String string2) {
        return stringService.append(string1, string2);
    }

    @GetMapping("/length")
    public int length(@RequestParam String string) {
        return stringService.length(string);
    }

    @GetMapping("/charAt")
    public char charAt(@RequestParam String string, @RequestParam int idx) {
        return stringService.charAt(string, idx);
    }

    @GetMapping("/equals")
    public boolean equals(@RequestParam String string1, @RequestParam String string2) {
        return stringService.equals(string1, string2);
    }
}