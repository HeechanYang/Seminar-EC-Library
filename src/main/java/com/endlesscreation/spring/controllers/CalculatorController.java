package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.sum(num1,num2);
    }

    @GetMapping("/subtraction")
    public int subtract(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.subtract(num1,num2);
    }

    @GetMapping("/multiplication")
    public int multiply(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping("/division")
    public int divide(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.divide(num1,num2);
    }

    @GetMapping("/modular")
    public int modular(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.modular(num1,num2);
    }

    @GetMapping("/power")
    public int power(@RequestParam int num1, @RequestParam int num2) {
       return calculatorService.power(num1,num2);
    }

    @GetMapping("/max")
    public int max(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.max(num1,num2);
    }

    @GetMapping("/min")
    public int min(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.min(num1, num2);
    }

    @GetMapping("/random")
    public int random() {
        return calculatorService.random();
    }
}
