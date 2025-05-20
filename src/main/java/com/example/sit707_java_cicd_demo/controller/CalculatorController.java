package com.example.sit707_java_cicd_demo.controller;
import com.example.sit707_java_cicd_demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, Java CI/CD on GCP!");
        return response;
    }

    @GetMapping("/add/{a}/{b}")
    public Map<String, Integer> add(@PathVariable int a, @PathVariable int b) {
        Map<String, Integer> response = new HashMap<>();
        response.put("result", calculatorService.add(a, b));
        return response;
    }

    @GetMapping("/subtract/{a}/{b}")
    public Map<String, Integer> subtract(@PathVariable int a, @PathVariable int b) {
        Map<String, Integer> response = new HashMap<>();
        response.put("result", calculatorService.subtract(a, b));
        return response;
    }

    @GetMapping("/multiply/{a}/{b}")
    public Map<String, Integer> multiply(@PathVariable int a, @PathVariable int b) {
        Map<String, Integer> response = new HashMap<>();
        response.put("result", calculatorService.multiply(a, b));
        return response;
    }

    @GetMapping("/divide/{a}/{b}")
    public Map<String, Double> divide(@PathVariable int a, @PathVariable int b) {
        Map<String, Double> response = new HashMap<>();
        response.put("result", calculatorService.divide(a, b));
        return response;
    }
}
