package com.svintsov;

import com.svintsov.intervals.Interval;
import com.svintsov.intervals.Intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntervalsTest {

    private Intervals intervals;

    @BeforeEach
    public void beforeEach() {
        intervals = new Intervals();
    }

    @Test
    public void testIntervals_1() {
        List<Interval> merged = intervals.merge(new int[][]{
                {1, 4},
                {3, 4},
                {5, 8},
                {7, 10}
        });
        merged.forEach(System.out::println);
    }

}