package com.endlesscreation.spring.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int modular(int num1, int num2) {
        return num1 % num2;
    }

    public int power(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    public int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public int min(int num1, int num2) {
        return Math.min(num1, num2);
    }

    public int random() {
        return (int) (Math.random() * 1000);
    }
}
