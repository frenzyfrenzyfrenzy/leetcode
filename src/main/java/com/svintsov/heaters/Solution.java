package com.svintsov.heaters;

import static java.util.Objects.isNull;

import java.util.Arrays;

public class Solution {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int[] heatersRadii = new int[heaters.length];
        int maxRadius = 0;

        for (int heaterIndex = 0; heaterIndex < heaters.length; heaterIndex++) {

            int currentHeaterPosition;
            Integer prevHeaterPosition;
            Integer nextHeaterPosition;
            int leftRadius;
            int rightRadius;
            Integer leftmostHousePosition = houses.length > 0 ? houses[0] : null;
            Integer rightmostHousePosition = houses.length > 0 ? houses[houses.length - 1] : null;

            currentHeaterPosition = heaters[heaterIndex];
            prevHeaterPosition = heaterIndex == 0 ? null : heaters[heaterIndex - 1];
            nextHeaterPosition = heaterIndex == heaters.length - 1 ? null : heaters[heaterIndex + 1];

            if (isNull(prevHeaterPosition)) {
                if (leftmostHousePosition != null && leftmostHousePosition < currentHeaterPosition) {
                    leftRadius = currentHeaterPosition - leftmostHousePosition;
                } else {
                    leftRadius = 0;
                }
            } else {
                leftRadius = (currentHeaterPosition - prevHeaterPosition) / 2;
                if (leftRadius > 0) {

                    int distanceToTheLeftHeaterArea = currentHeaterPosition - (prevHeaterPosition + heatersRadii[heaterIndex - 1]) - 1;
                    if (distanceToTheLeftHeaterArea < leftRadius) {
                        leftRadius = distanceToTheLeftHeaterArea;
                    }

                    leftmostHousePosition = findLeftmostHouseInRadius(houses, currentHeaterPosition - leftRadius, currentHeaterPosition - 1);
                    if (leftmostHousePosition != null) {
                        leftRadius = currentHeaterPosition - leftmostHousePosition;
                    } else {
                        leftRadius = 0;
                    }
                }
            }

            if (isNull(nextHeaterPosition)) {
                if (rightmostHousePosition != null && rightmostHousePosition > currentHeaterPosition) {
                    rightRadius = rightmostHousePosition - currentHeaterPosition;
                } else {
                    rightRadius = 0;
                }
            } else {
                rightRadius = (nextHeaterPosition - currentHeaterPosition) / 2;
                if (rightRadius > 0) {
                    rightmostHousePosition = findRightmostHouseInRadius(houses, currentHeaterPosition + 1, currentHeaterPosition + rightRadius);
                    if (rightmostHousePosition != null) {
                        rightRadius = rightmostHousePosition - currentHeaterPosition;
                    } else {
                        rightRadius = 0;
                    }
                }
            }

            heatersRadii[heaterIndex] = Math.max(leftRadius, rightRadius);
            if (heatersRadii[heaterIndex] > maxRadius) {
                maxRadius = heatersRadii[heaterIndex];
            }
        }

        return maxRadius;
    }

    private Integer findRightmostHouseInRadius(int[] houses, int start, int end) {
        int[] housesInRadius = findHousesInRadius(houses, start, end);
        if (housesInRadius.length > 0) {
            return housesInRadius[housesInRadius.length - 1];
        } else return null;
    }

    private Integer findLeftmostHouseInRadius(int[] houses, int start, int end) {
        int[] housesInRadius = findHousesInRadius(houses, start, end);
        if (housesInRadius.length > 0) {
            return housesInRadius[0];
        } else return null;
    }

    private int[] findHousesInRadius(int[] houses, int start, int end) {
        return Arrays.stream(houses)
                .filter(housePosition -> housePosition >= start)
                .filter(housePosition -> housePosition <= end)
                .toArray();
    }

}
