package com.svintsov.search;

import static java.util.Objects.isNull;
import static java.util.Optional.empty;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BinarySearch {

    public Optional<Integer> searchBinary(int[] input, int desired) {

        if (isNull(input) || input.length == 0) {
            return empty();
        }

        List<Integer> list = Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());

        return searchBinaryInternal(list, 0, list.size() - 1, desired);
    }

    private Optional<Integer> searchBinaryInternal(List<Integer> input, int startPosition, int endPosition, int desired) {
        //if search area contains of one element then check this element
        if (startPosition == endPosition) {
            if (input.get(startPosition).equals(desired)) {
                return Optional.of(startPosition);
            }
            return empty();
        }

        int nextPositionToCheck;
        int searchAreaSize = endPosition - startPosition + 1;
        if (searchAreaSize % 2 == 0) {
            //if search area contains even number of elements then we lean to the left
            nextPositionToCheck = startPosition + (searchAreaSize / 2 - 1);
        } else {
            //otherwise check the middle element
            nextPositionToCheck = startPosition + (searchAreaSize / 2);
        }

        Integer valueAtNextPosition = input.get(nextPositionToCheck);
        if (valueAtNextPosition == desired) {
            return Optional.of(nextPositionToCheck);
        }

        if (valueAtNextPosition < desired) {
            //check to the right of selected element, should always be at least one element left in search area
            return searchBinaryInternal(input, nextPositionToCheck + 1, endPosition, desired);
        } else {
            //we've just checked the left element of 2-element search area, nothing to the left
            if (startPosition == nextPositionToCheck) {
                return empty();
            }
            //there's something on the left, we'll search there
            return searchBinaryInternal(input, startPosition, nextPositionToCheck - 1, desired);
        }
    }

}
