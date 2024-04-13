package com.svintsov.rotatedsearch;

import java.util.Objects;

public class Solution {

    public boolean search(int[] nums, int target) {
        Integer breakPoint = findBreakPoint(nums, 0, nums.length - 1);
        if (Objects.nonNull(breakPoint)) {
            return binarySearch(nums, target, 0, breakPoint - 1) ||
                    binarySearch(nums, target, breakPoint, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
    }

    private Integer findBreakPoint(int[] nums, int startPosition, int endPosition) {
        if (endPosition==startPosition || endPosition < startPosition) {
            return null;
        }
        if (endPosition - startPosition==1) {
            if (nums[startPosition] > nums[endPosition]) {
                return endPosition;
            }
            return null;
        }
        int currentPosition = startPosition + (endPosition - startPosition) / 2;
        int currentValue = nums[currentPosition];
        int referenceValue = nums[nums.length - 1];
        if (currentValue < referenceValue) {
            return findBreakPoint(nums, startPosition, currentPosition);
        } else if (currentValue > referenceValue) {
            return findBreakPoint(nums, currentPosition, endPosition);
        } else {
            Integer breakPointToTheLeft = findBreakPoint(nums, startPosition, currentPosition);
            if (Objects.nonNull(breakPointToTheLeft)) {
                return breakPointToTheLeft;
            }
            return findBreakPoint(nums, currentPosition, endPosition);
        }
    }

    private boolean binarySearch(int[] nums, int target, int startPosition, int endPosition) {
        if (endPosition < startPosition) {
            return false;
        }
        if (endPosition==startPosition) {
            return nums[endPosition]==target;
        }
        int positionToCheck = startPosition + (endPosition - startPosition) / 2;
        int valueAtPosition = nums[positionToCheck];
        if (valueAtPosition==target) {
            return true;
        }
        if (valueAtPosition > target) {
            return binarySearch(nums, target, startPosition, positionToCheck - 1);
        } else {
            return binarySearch(nums, target, positionToCheck + 1, endPosition);
        }
    }

}
