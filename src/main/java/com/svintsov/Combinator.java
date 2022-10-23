package com.svintsov;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Combinator {

    private final List<Integer> numbers;
    private final Map<Integer, Set<Integer>> numbersToPositions;

    public Combinator(int[] numbers) {

        this.numbers = Arrays.stream(numbers)
                .boxed()
                .collect(toList());

        numbersToPositions = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Set<Integer> positions = numbersToPositions.get(numbers[i]);
            if (isNull(positions)) {
                numbersToPositions.put(numbers[i], new HashSet<>(Set.of(i)));
            } else {
                positions.add(i);
            }
        }
    }

    public Set<List<Integer>> calculateAllTermsValuesUnique(int sum, int numberOfTerms) {
        return calculateAllTermsPositions(sum, numberOfTerms).stream()
                .map(positions -> positions.stream().map(numbers::get).sorted().collect(toList()))
                .collect(Collectors.toSet());
    }

    public Set<Set<Integer>> calculateAllTermsPositions(int sum, int numberOfTerms) {
        return calculateInternal(0, sum, numberOfTerms);
    }

    private Set<Set<Integer>> calculateInternal(int startingFrom, int sum, int numberOfTerms) {
        if (numberOfTerms > 1) {
            Set<Set<Integer>> result = new HashSet<>();
            int reducedNumberOfTerms = numberOfTerms - 1;
            for (int i = startingFrom; i < numbers.size() - reducedNumberOfTerms; ++i) {
                int currentTerm = numbers.get(i);
                int remainder = sum - currentTerm;
                Set<Set<Integer>> t1 = calculateInternal(i + 1, remainder, reducedNumberOfTerms);
                Set<Set<Integer>> t2 = combineWithSet(i, t1);
                result.addAll(t2);
            }
            return result;
        } else {
            Set<Integer> foundPositions = numbersToPositions.get(sum);
            if (isNull(foundPositions)) {
                return new HashSet<>();
            } else {
                return foundPositions.stream()
                        .filter(position -> position >= startingFrom)
                        .map(position -> new HashSet<>(Set.of(position)))
                        .collect(Collectors.toSet());
            }
        }
    }

    private Set<Set<Integer>> combineWithSet(int number, Set<Set<Integer>> set) {
        set.forEach(internalSet -> internalSet.add(number));
        return set;
    }

}
