package com.svintsov.heaters;

//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Slf4j
public class Solution {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        ImpactZone[] impactZones = new ImpactZone[heaters.length];
        Integer firstHeaterWithImpact = null;

        Integer previousHeaterCoordinate;
        Integer currentHeaterCoordinate;
        Integer nextHeaterCoordinate;

        for (int heaterIndex = 0; heaterIndex < heaters.length; heaterIndex++) {

            previousHeaterCoordinate = heaterIndex - 1 >= 0 ? heaters[heaterIndex - 1] : null;
            currentHeaterCoordinate = heaters[heaterIndex];
            nextHeaterCoordinate = heaterIndex + 1 < heaters.length ? heaters[heaterIndex + 1] : null;

            if (nextHeaterCoordinate != null && houses[0] > nextHeaterCoordinate) {
                continue;
            }
            if (previousHeaterCoordinate != null && houses[houses.length - 1] < previousHeaterCoordinate) {
                break;
            }

            int impactZoneToTheLeft;
            int impactZoneToTheRight;
            if (heaterIndex == 0) {
                impactZoneToTheLeft = houses[0] > currentHeaterCoordinate ? 0 : currentHeaterCoordinate - houses[0];
                if (nextHeaterCoordinate == null) {
                    if (houses[houses.length - 1] > currentHeaterCoordinate) {
                        impactZoneToTheRight = houses[houses.length - 1] - currentHeaterCoordinate;
                    } else {
                        impactZoneToTheRight = 0;
                    }
                } else {
                    impactZoneToTheRight = (nextHeaterCoordinate - currentHeaterCoordinate) / 2;
                }
            } else if (heaterIndex == heaters.length - 1) {
                impactZoneToTheLeft = (currentHeaterCoordinate - previousHeaterCoordinate) / 2;
                impactZoneToTheRight = houses[houses.length - 1] > currentHeaterCoordinate ? houses[houses.length - 1] - currentHeaterCoordinate : 0;
            } else {
                impactZoneToTheLeft = (currentHeaterCoordinate - previousHeaterCoordinate) / 2;
                impactZoneToTheRight = (nextHeaterCoordinate - currentHeaterCoordinate) / 2;
            }
            impactZones[heaterIndex] = new ImpactZone(currentHeaterCoordinate - impactZoneToTheLeft, currentHeaterCoordinate + impactZoneToTheRight,
                    currentHeaterCoordinate);
            if (firstHeaterWithImpact == null) {
                firstHeaterWithImpact = heaterIndex;
            }
        }


        ImpactZone leftImpactZone = firstHeaterWithImpact != null ? impactZones[firstHeaterWithImpact] : null;
        if (leftImpactZone == null) {
            return 0;
        }
        ImpactZone rightImpactZone = firstHeaterWithImpact + 1 < heaters.length ? impactZones[firstHeaterWithImpact + 1] : null;
        int currentHeater = firstHeaterWithImpact;
        int maxRadius = -1;
        for (int houseCoordinate : houses) {
            while (!leftImpactZone.belongs(houseCoordinate)) {
                leftImpactZone.recalculate();
                int radius = leftImpactZone.getRadius();
                if (radius > maxRadius) {
                    maxRadius = radius;
                }
                leftImpactZone = rightImpactZone;
                rightImpactZone = currentHeater + 2 < heaters.length ? impactZones[currentHeater + 2] : null;
                currentHeater++;
            }
            if (leftImpactZone.belongs(houseCoordinate)) {
                leftImpactZone.addHouse(houseCoordinate);
            }
            if (rightImpactZone != null && rightImpactZone.belongs(houseCoordinate)) {
                rightImpactZone.addHouse(houseCoordinate);
            }
        }

        leftImpactZone.recalculate();
        int radius = leftImpactZone.getRadius();
        if (radius > maxRadius) {
            maxRadius = radius;
        }

        for (ImpactZone impactZone : impactZones) {
//            log.info("{}", impactZone);
        }

        return maxRadius;
    }

//    @ToString
    private static class ImpactZone {

        private int from;
        private int to;
        private int heater;
        private List<Integer> houses;
        private int radius;

        public ImpactZone(int from, int to, int heater) {
            this.from = from;
            this.to = to;
            this.heater = heater;
        }

        public int getRadius() {
            return radius;
        }

        public boolean belongs(int value) {
            return value >= from && value <= to;
        }

        public void addHouse(int house) {
            if (houses == null) {
                houses = new ArrayList<>();
            }
            houses.add(house);
        }

        public void recalculate() {
            if (houses != null) {
                if (houses.size() > 1) {
                    Integer leftmostHouse = houses.get(0);
                    Integer rightmostHouse = houses.get(houses.size() - 1);
                    if (leftmostHouse < heater) {
                        from = leftmostHouse;
                    } else {
                        from = heater;
                    }
                    if (rightmostHouse > heater) {
                        to = rightmostHouse;
                    } else {
                        to = heater;
                    }
                } else {
                    Integer house = houses.get(0);
                    if (house < heater) {
                        from = house;
                        to = heater;
                    } else if (house > heater) {
                        from = heater;
                        to = house;
                    } else {
                        from = heater;
                        to = heater;
                    }
                }
            } else {
                from = heater;
                to = heater;
            }

            radius = Math.max(heater - from, to - heater );
        }

    }

}
