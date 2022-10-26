package com.svintsov;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;

public class Calculator {

    private final Parser parser;

    public Calculator() {
        parser = new Parser();
    }

    public LinkedList<Integer> add(String input) {

        List<String> parsedInput = parser.parse(input.replaceAll("\\s", ""));
        List<Integer> openingBracketsPositions = new ArrayList<>();

        ListIterator<String> iterator = parsedInput.listIterator();
        while (iterator.hasNext()) {
            String firstRoundNext = iterator.next();
            if (firstRoundNext.equals("(")) {
                openingBracketsPositions.add(iterator.previousIndex());
            } else if (firstRoundNext.equals(")")) {
                int openingPosition = openingBracketsPositions.get(openingBracketsPositions.size() - 1);
                do {
                    iterator.previous();
                } while (iterator.hasPrevious() && !(iterator.previousIndex() == openingPosition - 1));
                openingBracketsPositions.remove(openingBracketsPositions.size() - 1);

                List<String> currentBracketExpression = new ArrayList<>();
                iterator.next();
                iterator.remove();
                String secondRoundNext = iterator.next();
                while (!secondRoundNext.equals(")")) {
                    currentBracketExpression.add(secondRoundNext);
                    iterator.remove();
                    secondRoundNext = iterator.next();
                }
                iterator.remove();
                System.out.println(currentBracketExpression);
                iterator.add(calculateBracket(currentBracketExpression));
            }
        }

        return new LinkedList<>();
    }

    private String calculateBracket(List<String> input) {
        ListIterator<String> iterator = input.listIterator();
        Integer previousPlusPosition = null;
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (Set.of("+", "-").contains(next)) {
                List<String> currentTermFactors = new ArrayList<>();
                while (iterator.hasPrevious() && !Objects.equals(iterator.previousIndex(), previousPlusPosition)) {
                    iterator.previous();
                }
            }
        }
        return null;
    }


}
