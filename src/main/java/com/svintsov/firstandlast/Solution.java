package com.svintsov.firstandlast;

class Solution {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1) {
            if (nums[0] != target) {
                return new int[]{-1, -1};
            } else {
                return new int[]{0, 0};
            }
        }

        return new int[]{
                searchRecursive(nums, 0, nums.length - 1, target, Boundary.LEFT),
                searchRecursive(nums, 0, nums.length - 1, target, Boundary.RIGHT),
        };
    }

    private int searchRecursive(int[] nums, int searchFrom, int searchTo, int target, Boundary boundary) {

        int indexToCheck = searchFrom + (searchTo - searchFrom) / 2;
        int numToCompare = nums[indexToCheck];

        if (searchFrom == searchTo) {
            if (boundary == Boundary.LEFT) {
                if ((target - 0.5) < numToCompare) {
                    return numToCompare == target ? indexToCheck:-1;
                } else {
                    return (searchTo + 1 < nums.length && nums[searchTo + 1] == target) ? searchTo + 1:-1;
                }
            } else {
                if ((target + 0.5) < numToCompare) {
                    return (searchTo - 1 >= 0 && nums[searchTo - 1] == target) ? searchTo - 1:-1;
                } else {
                    return numToCompare == target ? indexToCheck:-1;
                }
            }
        } else if (searchFrom - searchTo == 1) {
            if (boundary == Boundary.LEFT) {
                if ((target - 0.5) < numToCompare) {
                    return numToCompare == target ? indexToCheck:-1;
                }
                return searchRecursive(nums, searchFrom + 1, searchTo, target, boundary);
            } else {
                if ((target + 0.5) > numToCompare) {
                    return searchRecursive(nums, searchFrom + 1, searchTo, target, boundary);
                }
                return (searchFrom - 1 >= 0 && nums[searchFrom - 1] == target ? searchFrom - 1:-1);
            }
        } else {
            if (boundary == Boundary.LEFT) {
                if ((target - 0.5) < numToCompare) {
                    return searchRecursive(nums, searchFrom, indexToCheck - 1, target, boundary);
                } else {
                    return searchRecursive(nums, indexToCheck + 1, searchTo, target, boundary);
                }
            } else {
                if ((target + 0.5) < numToCompare) {
                    return searchRecursive(nums, searchFrom, indexToCheck - 1, target, boundary);
                } else {
                    return searchRecursive(nums, indexToCheck + 1, searchTo, target, boundary);
                }
            }
        }
    }

    enum Boundary {
        LEFT, RIGHT
    }
}
