package com.svintsov.jump;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class JumpGameTest {

    @Test
    public void test() {
        int jumps = new JumpGame().jump(new int[]{9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5});
        log.info("jumps: {}", jumps);
    }

}