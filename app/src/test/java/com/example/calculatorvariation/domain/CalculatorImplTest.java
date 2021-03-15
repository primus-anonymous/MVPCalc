package com.example.calculatorvariation.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    @Test
    public void testAddition() {
        CalculatorImpl calculator = new CalculatorImpl();

        double result = calculator.binaryOperation(5.0, 6.0, Operation.ADD);
        Assert.assertTrue(11.0 == result);
    }

}