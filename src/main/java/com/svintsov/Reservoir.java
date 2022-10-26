package com.svintsov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Reservoir {

    private int maxArea(int[] height) {

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            items.add(new Item(height[i], i));
        }
        items.sort(Comparator.comparing(Item::getHeight).reversed());

        int currentMaxVolume = 0;
        int absoluteMaxVolumePotential;
        int maxVolumePotential;
        for (int leftBorder = 0; leftBorder < items.size() - 1; leftBorder++) {
            Item biggerItem = items.get(leftBorder);
            int maxDistance = Math.max(biggerItem.getPosition(), items.size() - 1 - biggerItem.getPosition());
            maxVolumePotential = biggerItem.getHeight() * maxDistance;
            if (maxVolumePotential <= currentMaxVolume) {
                continue;
            }
            absoluteMaxVolumePotential = biggerItem.getHeight() * items.size();
            if (absoluteMaxVolumePotential <= currentMaxVolume) {
                return currentMaxVolume;
            }
            for (int rightBorder = leftBorder + 1; rightBorder < items.size(); rightBorder++) {

                Item smallerItem = items.get(rightBorder);
                maxVolumePotential = smallerItem.getHeight() * maxDistance;
                if (maxVolumePotential <= currentMaxVolume) {
                    break;
                }


                int currentVolume = smallerItem.getHeight() * (Math.abs(biggerItem.getPosition() - smallerItem.getPosition()));
                if (currentVolume > currentMaxVolume) {
                    currentMaxVolume = currentVolume;
                }
            }
        }
        return currentMaxVolume;
    }

    private static class Item {
        private final int height;
        private final int position;

        public Item(int height, int position) {
            this.height = height;
            this.position = position;
        }

        public int getHeight() {
            return height;
        }

        public int getPosition() {
            return position;
        }
    }

}
