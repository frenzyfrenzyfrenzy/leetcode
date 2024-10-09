package com.svintsov.firstandlast;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void beforeEach() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] ints = solution.searchRange(new int[]{0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10}, 4);
        log.info("{}:{}", ints[0], ints[1]);
    }

}