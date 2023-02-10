package com.svintsov.search;

import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
public class CutoffSearch {

    public int searchGreaterOrEqualCount(int[] input, int cutoff) {

        if (isNull(input) || input.length == 0) {
            return 0;
        }

        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());

        return searchGreaterOrEqualCountInternal(list, cutoff);
    }

    private int searchGreaterOrEqualCountInternal(List<Integer> input, int desired) {
        BinarySearchResult searchResult = binarySearch(0, input.size() - 1, input, desired);
        if (!searchResult.isExact()) {
            int closestPosition = searchResult.getPosition();
            int closestValue = input.get(closestPosition);
            if (closestValue < desired) {
                return input.size();
            } else {
                return input.size() - closestPosition;
            }
        }
        throw new UnsupportedOperationException();
    }

    private BinarySearchResult binarySearch(int searchZoneStart, int searchZoneEnd, List<Integer> input, int desired) {
        int searchZoneSize = searchZoneEnd - searchZoneStart + 1;
        int nextPositionToCheck;
        if (searchZoneSize % 2 == 0) {
            nextPositionToCheck = searchZoneStart + (searchZoneSize / 2 - 1);
        } else {
            nextPositionToCheck = searchZoneStart + (searchZoneSize / 2);
        }
        Integer valueToCheck = input.get(nextPositionToCheck);
        if (valueToCheck == desired) {
            return BinarySearchResult.of(nextPositionToCheck, true);
        }
        if (searchZoneSize == 1) {
            return BinarySearchResult.of(nextPositionToCheck, false);
        }
        if (valueToCheck < desired) {
            return binarySearch(nextPositionToCheck + 1, searchZoneEnd, input, desired);
        } else {
            if (nextPositionToCheck == searchZoneStart) {
                return BinarySearchResult.of(nextPositionToCheck, false);
            }
            return binarySearch(searchZoneStart, nextPositionToCheck - 1, input, desired);
        }
    }

    @Value
    @Getter
    @AllArgsConstructor(staticName = "of")
    private static class BinarySearchResult {
        int position;
        boolean exact;
    }

}
