package com.svintsov.intervals;

import static java.util.Comparator.comparing;
import static java.util.Objects.nonNull;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Intervals {

    public List<Interval> merge(int[][] intervals) {

        TreeMap<Integer, Interval> longestFromPointByBeginning = Arrays.stream(intervals)
                .map(intervalArray -> new Interval(intervalArray[0], intervalArray[1]))
                .collect(toMap(Interval::getBeginning, identity(), maxBy(comparing(Interval::getEnd)), TreeMap::new));

        List<Interval> result = new ArrayList<>();
        if (longestFromPointByBeginning.isEmpty()) {
            return result;
        }

        Interval currentInterval = longestFromPointByBeginning.entrySet().iterator().next().getValue();
        while (currentInterval != null) {

            merge(result, currentInterval);
            int currentBeginning = currentInterval.getBeginning();
            int currentEnd = currentInterval.getEnd();

            Interval longestAdjacent = longestFromPointByBeginning.entrySet().stream()
                    .dropWhile(entry -> entry.getKey() <= currentBeginning)
                    .takeWhile(entry -> entry.getKey() <= currentEnd)
                    .map(Map.Entry::getValue)
                    .filter(interval -> interval.getEnd() > currentEnd)
                    .max(comparing(Interval::getEnd))
                    .orElse(null);

            if (nonNull(longestAdjacent)) {
                currentInterval = longestAdjacent;
            } else {
                currentInterval = longestFromPointByBeginning.entrySet().stream()
                        .dropWhile(entry -> entry.getKey() < currentEnd)
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .orElse(null);
            }
        }

        return result;
    }

    private void merge(List<Interval> exising, Interval newOne) {

        if (exising.isEmpty()) {
            exising.add(newOne);
            return;
        }

        Interval last = exising.get(exising.size() - 1);
        if (last.getEnd() >= newOne.getBeginning()) {
            exising.remove(last);
            exising.add(new Interval(last.getBeginning(), newOne.getEnd()));
        } else {
            exising.add(newOne);
        }
    }
}
