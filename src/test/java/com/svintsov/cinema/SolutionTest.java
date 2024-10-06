package com.svintsov.cinema;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void beforeEach() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.combine(10, 3);
        result.forEach(integers -> log.info("{}", integers));
    }

}