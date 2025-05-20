package com.example.sit707_java_cicd_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testAddSuccess() {
        assertEquals(5, calculatorService.add(2, 3));
        assertEquals(0, calculatorService.add(-1, 1));
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    public void testAddFailure() {
        // This test is designed to fail intentionally
        assertEquals(4, calculatorService.add(2, 2)); // Should be 4, not 5
    }

    @Test
    public void testSubtractSuccess() {
        assertEquals(-1, calculatorService.subtract(2, 3));
        assertEquals(-2, calculatorService.subtract(-1, 1));
        assertEquals(0, calculatorService.subtract(0, 0));
    }

    @Test
    public void testMultiplySuccess() {
        assertEquals(6, calculatorService.multiply(2, 3));
        assertEquals(-1, calculatorService.multiply(-1, 1));
        assertEquals(0, calculatorService.multiply(0, 5));
    }

    @Test
    public void testDivideSuccess() {
        assertEquals(2.0, calculatorService.divide(6, 3));
        assertEquals(-0.5, calculatorService.divide(-1, 2));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(5, 0);
        });
    }
}
