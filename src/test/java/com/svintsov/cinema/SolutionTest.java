package com.svintsov.cinema;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Map.entry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@Slf4j
class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void beforeEach() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> occupation = newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Set<Entry<Integer, Integer>> aisles = newHashSet(entry(2,3), entry(6,7));

        List<List<Integer>> result = solution.combine(occupation, aisles, 4);

        result.forEach(integers -> log.info("{}", integers));
    }

}