package com.svintsov.cinema;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
class Solution {

    public List<List<Integer>> combine(int listSize, int segmentSize) {

        ArrayList<List<Integer>> possibleCombinations = new ArrayList<>();
        List<Integer> defualtList = new ArrayList<>(Stream.generate(() -> 0)
                .limit(listSize)
                .toList());

        combineInternal(defualtList, segmentSize, 0, possibleCombinations);

        return possibleCombinations;
    }

    private void combineInternal(
            List<Integer> currentCombination, int segmentSize, int lastPosition, List<List<Integer>> possibleCombinations) {

        int currentStartPosition;
        if (lastPosition==0) {
            currentStartPosition = 0;
        } else {
            currentStartPosition = lastPosition + 2;
        }

        if ((currentCombination.size() - currentStartPosition) < segmentSize) {
            possibleCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        while ((currentCombination.size() - currentStartPosition) >= segmentSize) {
            for (int j = 0; j < segmentSize; ++j) {
                currentCombination.set(currentStartPosition + j, 1);
            }
            combineInternal(currentCombination, segmentSize, currentStartPosition + segmentSize - 1, possibleCombinations);
            for (int j = 0; j < segmentSize; ++j) {
                currentCombination.set(currentStartPosition + j, 0);
            }
            currentStartPosition++;
        }
    }

}
