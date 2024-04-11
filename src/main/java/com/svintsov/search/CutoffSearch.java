package com.svintsov.search;

public class CutoffSearch {

    public int countGreaterOrEqual(int[] input, int value) {
        int position = findPosition(input, value);
        return input.length - position;
    }

    private int findPosition(int[] input, int valueToFind) {
        if (input.length==0) {
            return 0;
        }
        return findPosition(input, 0, input.length - 1, valueToFind);
    }

    private int findPosition(int[] array, int startPosition, int endPosition, int valueToFind) {
        int positionToCheck = startPosition + (endPosition - startPosition) / 2;
        if (array[positionToCheck]==valueToFind) {
            if (positionToCheck==0) {
                return positionToCheck;
            }
            return findLowestPosition(array, 0, positionToCheck, valueToFind);
        }
        if (startPosition==endPosition) {
            return positionToCheck;
        }
        if (array[positionToCheck] > valueToFind) {
            if (positionToCheck==0) {
                return positionToCheck;
            }
            return findPosition(array, startPosition, positionToCheck - 1, valueToFind);
        } else {
            return findPosition(array, positionToCheck + 1, endPosition, valueToFind);
        }
    }

    private int findLowestPosition(int[] array, int startPosition, int endPosition, int value) {
        if (startPosition==endPosition) {
            return startPosition;
        }
        int positionToCheck = startPosition + (endPosition - startPosition) / 2;
        if (array[positionToCheck]==value) {
            return findLowestPosition(array, startPosition, positionToCheck, value);
        } else {
            return findLowestPosition(array, startPosition + 1, endPosition, value);
        }
    }

}
