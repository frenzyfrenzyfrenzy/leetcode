package com.svintsov.palindrome;

import java.util.LinkedList;
import java.util.List;

public class PalindromeParser {

    public boolean isPalindrome(int input) {
        List<Integer> parsedDigits = parseDigits(input);
        int currentIndex = 0;
        while (currentIndex < parsedDigits.size() / 2) {
            Integer thisDigit = parsedDigits.get(currentIndex);
            Integer counterpart = parsedDigits.get(parsedDigits.size() - 1 - currentIndex);
            if (!thisDigit.equals(counterpart)) {
                return false;
            }
            currentIndex++;
        }
        return true;
    }

    public List<Integer> parseDigits(int input) {
        LinkedList<Integer> parsedDigits = new LinkedList<>();
        int currentDigit = 0;
        do {
            int nthDigit = getNthDigit(input, currentDigit);
            parsedDigits.addFirst(nthDigit);
            currentDigit++;
        } while (!isDigitLast(input, currentDigit - 1));
        return parsedDigits;
    }

    private boolean isDigitLast(int input, int n) {
        int biggerRemainder = input % ((int) Math.pow(10, n + 1));
        int smallerRemainder = input % ((int) Math.pow(10, n));
        return biggerRemainder == input && biggerRemainder != smallerRemainder;
    }

    private int getNthDigit(int input, int n) {
        int remainder = input % ((int) Math.pow(10, n + 1));
        return remainder / ((int) Math.pow(10, n));
    }

}
