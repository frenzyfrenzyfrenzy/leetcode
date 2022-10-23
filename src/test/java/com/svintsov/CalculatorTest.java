package com.svintsov;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculator_1() {
        LinkedList<Integer> first = new LinkedList<>(Arrays.asList(3,2,1));
        LinkedList<Integer> second = new LinkedList<>(Arrays.asList(6,5,4));
        LinkedList<Integer> result = calculator.add(first, second);
        assertThat(result).containsExactly(9,7,5);
    }

    @Test
    public void testCalculator_2() {
        LinkedList<Integer> first = new LinkedList<>(Arrays.asList(3,2,1));
        LinkedList<Integer> second = new LinkedList<>(Arrays.asList(5,4));
        LinkedList<Integer> result = calculator.add(first, second);
        assertThat(result).containsExactly(8,6,1);
    }

}