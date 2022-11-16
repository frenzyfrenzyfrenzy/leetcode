package com.svintsov.palindrome;

import java.util.LinkedList;
import java.util.List;

public class RecurisvePalindrome {

    public List<Integer> revert(int input) {
        LinkedList<Integer> splitDigits =  new LinkedList<>();
        splitIntoDigits(0, splitDigits, input);

        LinkedList<Integer> reverted = new LinkedList<>();
        splitDigits.forEach(reverted::addFirst);
        return reverted;
    }

    private void splitIntoDigits(int currentDigit, LinkedList<Integer> digitsResult, int input) {
        int remainder = (int) (input % Math.pow(10, currentDigit + 1));
        boolean isLastDigit = remainder == input;
        int digit = (int) (remainder / Math.pow(10, currentDigit));
        digitsResult.addFirst(digit);
        if (isLastDigit) {
            return;
        }
        splitIntoDigits(currentDigit + 1, digitsResult, input);
    }

}
