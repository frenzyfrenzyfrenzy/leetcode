package com.svintsov.cinema;

import static java.util.Map.entry;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {

    private static final int ROW_LENGTH = 10;
    private static final int FAMILY_SIZE = 4;
    private static final Set<Entry<Integer, Integer>> AISLES = Set.of(entry(2, 3), entry(6, 7));

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, List<Integer>> rowNumbersToOccupationFlags = Arrays.stream(reservedSeats)
                .collect(Collectors.groupingBy(ints -> ints[0], mapping(ints -> ints[1], toList())))
                .entrySet()
                .stream()
                .map(rowNumberToOccupiedSeatsNumbers -> {
                    List<Integer> occupationFlags = IntStream.range(1, ROW_LENGTH + 1)
                            .mapToObj(seatNumber -> rowNumberToOccupiedSeatsNumbers.getValue().contains(seatNumber) ? 1:0)
                            .toList();
                    return entry(rowNumberToOccupiedSeatsNumbers.getKey(), occupationFlags);
                })
                .collect(toMap(Entry::getKey, Entry::getValue));

        for (int i = 1; i <= n; ++i) {
            if (rowNumbersToOccupationFlags.containsKey(i)) {
                continue;
            } else {
                rowNumbersToOccupationFlags.put(i, emptyListOfSize(ROW_LENGTH));
            }
        }

        return rowNumbersToOccupationFlags
                .values()
                .stream()
                .map(occupationFlags -> {
                    int maxSegmentsCount = combine(occupationFlags, AISLES, FAMILY_SIZE).getMaxSegmentsCount();
//                    System.out.println(occupationFlags);
//                    System.out.println(maxSegmentsCount);
                    return maxSegmentsCount;
                })
                .reduce(Integer::sum)
                .orElse(0);
    }

    public CombineResponse combine(List<Integer> rowOccupation, Set<Entry<Integer, Integer>> aisles, int familySize) {

        ArrayList<List<Integer>> possibleCombinations = new ArrayList<>();

        List<Integer> emptyRow = emptyListOfSize(rowOccupation.size());

        AtomicInteger currentSegmentsCount = new AtomicInteger(0);
        AtomicInteger maxSegmentsCount = new AtomicInteger(0);

        combineInternal(rowOccupation, emptyRow, aisles, familySize, 0,
                maxSegmentsCount, currentSegmentsCount, possibleCombinations);

        return new CombineResponse(possibleCombinations, maxSegmentsCount.get());
    }

    private void combineInternal(
            List<Integer> currentOccupation,
            List<Integer> currentCombination,
            Set<Entry<Integer, Integer>> aisles,
            int segmentSize,
            int lastPosition,
            AtomicInteger maxSegmentsCount,
            AtomicInteger currentSegmentsCount,
            List<List<Integer>> possibleCombinations) {

        int currentStartPosition;
        if (lastPosition == 0) {
            currentStartPosition = 0;
        } else {
            currentStartPosition = lastPosition + 1;
        }

        if ((currentCombination.size() - currentStartPosition) < segmentSize) {
            possibleCombinations.add(new ArrayList<>(currentCombination));
            if (currentSegmentsCount.get() > maxSegmentsCount.get()) {
                maxSegmentsCount.set(currentSegmentsCount.get());
            }
            return;
        }

        boolean combinationIsFinal = true;
        while (currentStartPosition < currentCombination.size() - 1) {
            if (possibleToPutSegment(segmentSize, currentOccupation, aisles, currentCombination, currentStartPosition)) {
                combinationIsFinal = false;
                for (int j = 0; j < segmentSize; ++j) {
                    currentCombination.set(currentStartPosition + j, 1);
                }
                currentSegmentsCount.incrementAndGet();
                combineInternal(currentOccupation, currentCombination, aisles, segmentSize, currentStartPosition + segmentSize - 1,
                        maxSegmentsCount, currentSegmentsCount, possibleCombinations);
                currentSegmentsCount.decrementAndGet();
                for (int j = 0; j < segmentSize; ++j) {
                    currentCombination.set(currentStartPosition + j, 0);
                }
            }
            currentStartPosition++;
        }

        if (combinationIsFinal) {
            possibleCombinations.add(new ArrayList<>(currentCombination));
            if (currentSegmentsCount.get() > maxSegmentsCount.get()) {
                maxSegmentsCount.set(currentSegmentsCount.get());
            }
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
                if (aisles.contains(entry(startPosition, startPosition + 1))) {
                    return false;
                }
            }
            if (i == segmentSize - 1) {
                if (aisles.contains(entry(startPosition + segmentSize - 2, startPosition + segmentSize - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> emptyListOfSize(int size) {
        return new ArrayList<>(Stream.generate(() -> 0)
                .limit(size)
                .toList());
    }

    public static class CombineResponse {

        private final List<List<Integer>> allCombinations;
        private final int maxSegmentsCount;

        public CombineResponse(List<List<Integer>> allCombinations, int maxSegmentsCount) {
            this.allCombinations = allCombinations;
            this.maxSegmentsCount = maxSegmentsCount;
        }

        public List<List<Integer>> getAllCombinations() {
            return allCombinations;
        }

        public int getMaxSegmentsCount() {
            return maxSegmentsCount;
        }
    }

}
