package com.svintsov.jump;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JumpGame {

    public int jump(int[] nums) {

        int current = 0;
        int currentFurthestPossible = Math.min(nums[0], nums.length - 1);
        int next = currentFurthestPossible;
        int nextAfterNextCandidate = next + Math.min(nums[next], nums.length - 1);
        int jumps = 0;

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 1; i < nums.length; ++i) {
            if (Math.min(i + nums[i], nums.length - 1) > nextAfterNextCandidate) {
                nextAfterNextCandidate = Math.min(i + nums[i], nums.length - 1);
                next = i;
            }
            if (i==currentFurthestPossible) {
                current = next;
                jumps++;
                nextAfterNextCandidate = Math.min(current + nums[current], nums.length - 1);
                currentFurthestPossible = nextAfterNextCandidate;
                next = nextAfterNextCandidate;
            }
        }

        return jumps;
    }

}
