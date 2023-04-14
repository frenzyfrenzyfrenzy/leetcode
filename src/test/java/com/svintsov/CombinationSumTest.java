package com.svintsov;

import static com.google.common.collect.Lists.newArrayList;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
class CombinationSumTest {

    private CombinationSum combinationSum;

    @BeforeEach
    public void beforeEach() {
        combinationSum = new CombinationSum();
    }

    @Test
    public void testCombination() {
        ArrayList<Integer> terms = newArrayList(1, 2, 1, 2, 1, 2);
        Set<Set<Integer>> resultIndexes = combinationSum.combinationSum(terms, 7);

        resultIndexes.stream()
                .map(indexes -> indexes.stream().map(terms::get).collect(Collectors.toList()))
                .forEach(values -> log.info("Result values: {}", values));

        log.info("------------------------------");

        resultIndexes
                .forEach(indexes -> log.info("Result indexes: {}", indexes));
    }

}