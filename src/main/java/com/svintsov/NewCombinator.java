package com.svintsov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewCombinator {

    public List<List<Integer>> combinationSum2(int[] input, int sum) {
        List<List<Integer>> decompositionByPosition = decomposeInternal(input, 0, sum);
        return decompositionByPosition.stream()
                .map(decomposition -> decomposition.stream().map(position -> input[position]).sorted().collect(Collectors.toList()))
                .distinct()
                .collect(Collectors.toList());
    }

    private List<List<Integer>> decomposeInternal(int[] input, int startingFrom, int sum) {
        if (sum < 0) {
            return List.of();
        }
        if (startingFrom == input.length - 1 && input[input.length - 1] == sum) {
            return List.of(List.of(input.length - 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = startingFrom; i < input.length; i++) {
            if (sum == input[i]) {
                result.add(List.of(i));
            } else {
                List<List<Integer>> nextDecompositions = decomposeInternal(input, i + 1, sum - input[i]);
                result.addAll(combine(i, nextDecompositions));
            }
        }
        return result;
    }

    private List<List<Integer>> combine(int number, List<List<Integer>> decompositions) {
        return decompositions.stream()
                .map(ArrayList::new)
                .peek(decomposition -> decomposition.add(number))
                .collect(Collectors.toList());
    }

}
