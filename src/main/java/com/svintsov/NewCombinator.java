package com.svintsov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NewCombinator {

    public List<List<Integer>> combinationSum2(int[] input, int sum) {
        input = Arrays.stream(input).filter(value -> value <= sum).toArray();
        Arrays.sort(input);
        int total = Arrays.stream(input).sum();
        if (total < sum) {
            return new ArrayList<>();
        }
        return new ArrayList<>(decomposeInternal(input, 0, sum));
    }

    private Set<List<Integer>> decomposeInternal(int[] input, int startingFrom, int sum) {

        if (sum < 0) {
            return new HashSet<>();
        }

        Set<List<Integer>> result = new HashSet<>();

        if (startingFrom == input.length - 1 && input[input.length - 1] == sum) {
            List<Integer> e = new ArrayList<>();
            e.add(input[input.length - 1]);
            result.add(e);
            return result;
        }

        for (int i = startingFrom; i < input.length; i++) {
            int inputAtI = input[i];
            if (sum == inputAtI) {
                List<Integer> e = new ArrayList<>();
                e.add(inputAtI);
                result.add(e);
            } else {
                Set<List<Integer>> nextDecompositions = decomposeInternal(input, i + 1, sum - inputAtI);
                result.addAll(combine(inputAtI, nextDecompositions));
            }
        }

        return result;
    }

    private Set<List<Integer>> combine(int number, Set<List<Integer>> decompositions) {
        decompositions.forEach(integers -> integers.add(number));
        return decompositions;
    }

}
