package com.svintsov.jump;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JumpGame {

    private int smallestAmountOfJumps = 0;

    public int jump(int[] nums) {
        smallestAmountOfJumps = nums.length - 1;
        jumpNext(0, 0, nums);
        return smallestAmountOfJumps;
    }

    private void jumpNext(int currentJumps, int currentPad, int[] jumpPads) {

        if (smallestAmountOfJumps==1) {
            return;
        }

        if (currentJumps >= smallestAmountOfJumps) {
            return;
        }

        if (currentPad==jumpPads.length - 1) {
            smallestAmountOfJumps = currentJumps;
        } else {
            int jumpDistance = jumpPads[currentPad];
            if (jumpDistance > 0) {
                int nextLimit = Math.min(currentPad + jumpDistance, jumpPads.length - 1);
                for (int nextPad = nextLimit; nextPad >= currentPad + 1; nextPad--) {
                    jumpNext(currentJumps + 1, nextPad, jumpPads);
                }
            }
        }

    }

}
