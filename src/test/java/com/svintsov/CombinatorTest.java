package com.svintsov;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class CombinatorTest {

    private Combinator combinator;

    @Test
    public void combinatorTest_1() {
        combinator = new Combinator(new int[]{1, 1, 1, 2, 2, 2});
        Set<List<Integer>> result = combinator.calculateAllTermsValuesUnique(4, 3);
        result.forEach(System.out::println);
    }

    @Test
    public void combinatorTest_2() {
        combinator = new Combinator(new int[]{1, 1, 1, 2, 2, 2});
        Set<Set<Integer>> result = combinator.calculateAllTermsPositions(4, 3);
        result.forEach(System.out::println);
    }

}