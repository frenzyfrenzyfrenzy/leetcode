package com.svintsov.cinema;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Map.entry;

import com.svintsov.cinema.Solution.CombineResponse;
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
    public void testWithoutOccupation() {
        List<Integer> occupation = newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Set<Entry<Integer, Integer>> aisles = newHashSet(entry(2, 3), entry(6, 7));

        CombineResponse result = solution.combine(occupation, aisles, 4);

        result.getAllCombinations().forEach(integers -> log.info("{}", integers));
        log.info("max families: {}", result.getMaxSegmentsCount());
    }

    @Test
    public void testWithOccupation() {
        List<Integer> occupation = newArrayList(1, 0, 0, 0, 0, 0, 0, 0, 0, 1);

        Set<Entry<Integer, Integer>> aisles = newHashSet(entry(2, 3), entry(6, 7));

        CombineResponse result = solution.combine(occupation, aisles, 4);

        result.getAllCombinations().forEach(integers -> log.info("{}", integers));
        log.info("max families: {}", result.getMaxSegmentsCount());
    }

    @Test
    public void testSolution() {

//        [[4,7],[4,1],[3,1],[5,9],[4,4],[3,7],[1,3],[5,5],[1,6],[1,8],[3,9],[2,9],[1,4],[1,9],[1,10]]

        int maxFamilies = solution.maxNumberOfFamilies(5, new int[][]{
                new int[]{4, 7},
                new int[]{4, 1},
                new int[]{3, 1},
                new int[]{5, 9},
                new int[]{4, 4},
                new int[]{3, 7},
                new int[]{1, 3},
                new int[]{5, 5},
                new int[]{1, 6},
                new int[]{1, 8},
                new int[]{3, 9},
                new int[]{2, 9},
                new int[]{1, 4},
                new int[]{1, 9},
                new int[]{1, 10},

        });

        log.info("max families: {}", maxFamilies);
    }

}