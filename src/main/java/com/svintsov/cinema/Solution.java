package com.svintsov.cinema;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
class Solution {

    public List<List<Integer>> combine(List<Integer> rowOccupation, Set<Entry<Integer, Integer>> aisles, int familySize) {

        ArrayList<List<Integer>> possibleCombinations = new ArrayList<>();

        List<Integer> emptyRow = new ArrayList<>(Stream.generate(() -> 0)
                .limit(rowOccupation.size())
                .toList());

        combineInternal(rowOccupation, emptyRow, aisles, familySize, 0, possibleCombinations);

        return possibleCombinations;
    }

    private void combineInternal(
            List<Integer> currentOccupation,
            List<Integer> currentCombination,
            Set<Entry<Integer, Integer>> aisles,
            int segmentSize,
            int lastPosition,
            List<List<Integer>> possibleCombinations) {

        int currentStartPosition;
        if (lastPosition == 0) {
            currentStartPosition = 0;
        } else {
            currentStartPosition = lastPosition + 2;
        }

        if ((currentCombination.size() - currentStartPosition) < segmentSize) {
            possibleCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        while (currentStartPosition < currentCombination.size() - 1) {
            if (possibleToPutSegment(segmentSize, currentOccupation, aisles, currentCombination, currentStartPosition)) {
                for (int j = 0; j < segmentSize; ++j) {
                    currentCombination.set(currentStartPosition + j, 1);
                }
                combineInternal(currentOccupation, currentCombination, aisles, segmentSize, currentStartPosition + segmentSize - 1,
                        possibleCombinations);
                for (int j = 0; j < segmentSize; ++j) {
                    currentCombination.set(currentStartPosition + j, 0);
                }
            }
            currentStartPosition++;
        }
    }

    private boolean possibleToPutSegment(int segmentSize,
                                         List<Integer> currentOccupation,
                                         Set<Entry<Integer, Integer>> aisles,
                                         List<Integer> currentCombination,
                                         int startPosition) {
        for (int i = 0; i < segmentSize; ++i) {
            if (startPosition + i >= currentCombination.size()) {
                return false;
            }
            if (currentOccupation.get(startPosition + i) == 1) {
                return false;
            }
            if (i == 0) {
                if (aisles.contains(Map.entry(startPosition, startPosition + 1))) {
                    return false;
                }
            }
            if (i == segmentSize - 1) {
                if (aisles.contains(Map.entry(startPosition + segmentSize, startPosition + segmentSize - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

}
