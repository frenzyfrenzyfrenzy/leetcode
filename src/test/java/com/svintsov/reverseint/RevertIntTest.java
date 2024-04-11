package com.svintsov.reverseint;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class RevertIntTest {

    @Test
    public void test() {
        int result = new Solution().reverse(123);
        log.info("{}", result);
    }

}