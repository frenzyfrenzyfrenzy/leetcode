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
        int[] houses = new int[]{474833169,264817709,998097157,817129560};
        int[] heaters = new int[]{197493099,404280278,893351816,505795335};
        log.info("{}", solution.findRadius(houses, heaters));
    }

}