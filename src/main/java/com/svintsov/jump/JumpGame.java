package com.svintsov.jump;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JumpGame {

    public int jump(int[] nums) {
        ArrayList<List<Integer>> fullTrajectories = new ArrayList<>();
        jumpNext(fullTrajectories, new ArrayList<>(Arrays.asList(0)), nums);
        return fullTrajectories.stream()
                .map(List::size)
                .min(Integer::compare)
                .orElse(Integer.MAX_VALUE) - 1;
    }

    private void jumpNext(List<List<Integer>> fullTrajectories, List<Integer> currentTrajectory, int[] jumpPads) {
        Integer currentPad = currentTrajectory.get(currentTrajectory.size() - 1);
        if (currentPad==jumpPads.length - 1) {
            fullTrajectories.add(new ArrayList<>(currentTrajectory));
        } else {
            int jumpDistance = jumpPads[currentPad];
            if (jumpDistance > 0) {
                for (int nextPad = currentPad + 1; nextPad <= Math.min(currentPad + jumpDistance, jumpPads.length - 1); nextPad++) {
                    currentTrajectory.add(nextPad);
                    jumpNext(fullTrajectories, currentTrajectory, jumpPads);
                    currentTrajectory.remove(currentTrajectory.size() - 1);
                }
            }
        }

    }

}
