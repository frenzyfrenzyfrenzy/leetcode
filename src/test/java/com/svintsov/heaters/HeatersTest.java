package com.svintsov.heaters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class HeatersTest {

    private Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }


    @Test
    void test() {
        int[] houses = new int[]{1, 2, 3, 5, 15};
        int[] heaters = new int[]{2, 30};
        int radius = solution.findRadius(houses, heaters);
        log.info("radius: {}", radius);
    }

}