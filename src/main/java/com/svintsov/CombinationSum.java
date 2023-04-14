package com.svintsov;

import static com.google.common.collect.Sets.newHashSet;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
class CombinationSum {

    public Set<Set<Integer>> combinationSum(List<Integer> terms, Integer sum) {
        List<Integer> indexes = IntStream.range(0, terms.size()).boxed().collect(Collectors.toList());
        return getPossibleCombinations(terms, indexes, sum);
    }

    private Set<Set<Integer>> getPossibleCombinations(List<Integer> terms, List<Integer> indexesToConsider, Integer sum) {

        log.debug("Getting possible combinations for terms: {}, indexes to consider: {}, sum: {}", terms, indexesToConsider, sum);

        if (sum < 0 || indexesToConsider.isEmpty()) {
            log.debug("Sum {} is less then zero or no indexes left to consider, so no combinations can be made", sum);
            return newHashSet();
        }

        Set<Set<Integer>> newCombinations = newHashSet();
        if (indexesToConsider.size() == 1) {
            if (sum.equals(terms.get(indexesToConsider.get(0)))) {
                newCombinations.add(newHashSet(indexesToConsider.get(0)));
            }
            return newCombinations;
        }

        for (int indexOfIndexToConsider = 0; indexOfIndexToConsider < indexesToConsider.size(); indexOfIndexToConsider++) {
            Set<Set<Integer>> combinationsForIteration = newHashSet();
            int nextSum = sum - terms.get(indexesToConsider.get(indexOfIndexToConsider));
            if (nextSum == 0) {
                combinationsForIteration.add(newHashSet(indexesToConsider.get(indexOfIndexToConsider)));
                newCombinations.addAll(combinationsForIteration);
                continue;
            }

            boolean isBeforeLastElement = indexOfIndexToConsider == indexesToConsider.size() - 2;
            List<Integer> nextIndexesOfTerms;
            if (isBeforeLastElement) {
                nextIndexesOfTerms = indexesToConsider.subList(indexesToConsider.size() - 1, indexesToConsider.size());
            } else {
                nextIndexesOfTerms = indexesToConsider.subList(indexOfIndexToConsider + 1, indexesToConsider.size());
            }
            Set<Set<Integer>> possibleCombinations = getPossibleCombinations(terms, nextIndexesOfTerms, nextSum);
            Integer indexToConsider = indexesToConsider.get(indexOfIndexToConsider);
            combinationsForIteration = combine(indexToConsider, possibleCombinations);
            newCombinations.addAll(combinationsForIteration);
        }

        return newCombinations;
    }

    private Set<Set<Integer>> combine(Integer newIndex, Set<Set<Integer>> existingCombinations) {
        existingCombinations.forEach(combination -> combination.add(newIndex));
        return existingCombinations;
    }

}