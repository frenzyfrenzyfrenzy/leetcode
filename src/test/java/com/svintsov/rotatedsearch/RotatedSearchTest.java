package com.svintsov.rotatedsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class RotatedSearchTest {

    @Test
    public void testFindInRotated() {
        int[] array = {};
        log.info("{}", new Solution().search(array, 0));
        log.info("{}", new Solution().search(array, 1));
        log.info("{}", new Solution().search(array, 2));
        log.info("{}", new Solution().search(array, 3));
        log.info("{}", new Solution().search(array, 4));
        log.info("{}", new Solution().search(array, 5));
        log.info("{}", new Solution().search(array, 6));
    }

  /*  @Test
    public void testBreakpoint() {
        int[] array = {};
        Integer breakPoint = new Solution().findBreakPoint(array, 0, array.length - 1);
        log.info("{}", breakPoint);
    }

    @Test
    public void testBinarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean found = new Solution().binarySearch(array, 10, 0, array.length - 1);
        log.info("{}", found);
    }*/

}