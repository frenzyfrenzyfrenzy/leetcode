package com.svintsov.matrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class MatrixRotatorTest {

    private MatrixRotator matrixRotator;

    @BeforeEach
    public void beforeEach() {
        matrixRotator = new MatrixRotator();
    }

    @Test
    public void testSpiral() {
        List<Integer> spiral = matrixRotator.spiralOrder(new int[][]
                {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {11, 12, 13, 14, 15}
                });
        log.info("{}", spiral);
    }

}