package com.svintsov.jump;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class JumpGameTest {

    @Test
    public void test() {
        int jumps = new JumpGame().jump(new int[]{2,3,1,1,4});
        log.info("jumps: {}", jumps);
    }

}