package com.svintsov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculator_1() {
        calculator.add("(123*345-12)+4325+(12/5)");
    }

}