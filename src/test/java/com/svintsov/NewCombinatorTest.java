package com.svintsov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class NewCombinatorTest {

    private NewCombinator newCombinator;

    @BeforeEach
    public void beforeEach() {
        newCombinator = new NewCombinator();
    }

    @Test
    public void testDecomposition_1() {
        List<List<Integer>> result = newCombinator.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        result.forEach(System.out::println);
    }

}