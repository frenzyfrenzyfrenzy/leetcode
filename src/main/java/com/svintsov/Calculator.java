package com.svintsov;

import java.util.Iterator;
import java.util.LinkedList;

public class Calculator {

    public LinkedList<Integer> add(LinkedList<Integer> first, LinkedList<Integer> second) {
        Iterator<Integer> firstIterator = first.iterator();
        Iterator<Integer> secondIterator = second.iterator();
        LinkedList<Integer> result = new LinkedList<>();
        boolean hasOverflow = false;
        while (firstIterator.hasNext() || secondIterator.hasNext()) {
            boolean firstHasNext = firstIterator.hasNext();
            boolean secondHasNext = secondIterator.hasNext();
            Integer firstTerm;
            if (firstHasNext) {
                firstTerm = firstIterator.next();
            } else {
                firstTerm = 0;
            }
            Integer secondTerm;
            if (secondHasNext) {
                secondTerm = secondIterator.next();
            } else {
                secondTerm = 0;
            }
            int sum = firstTerm + secondTerm + (hasOverflow ? 1 : 0);
            if (sum >= 10) {
                hasOverflow = true;
                sum = sum - 10;
            }
            result.add(sum);
        }
        return result;
    }

}
