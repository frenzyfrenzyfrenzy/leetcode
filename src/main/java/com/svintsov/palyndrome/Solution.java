package com.svintsov.palyndrome;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

//@Slf4j
class Solution {

    private String original;

    public String longestPalindrome(String s) {

        original = s;

        List<Character> input = s.chars().mapToObj(value -> (char) value).collect(Collectors.toList());

        List<Palindrome> palindromes = new ArrayList<>();
        for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
            char currentChar = input.get(currentIndex);

            ListIterator<Palindrome> palindromeIterator = palindromes.listIterator();
            while (palindromeIterator.hasNext()) {

                Palindrome currentPalindrome = palindromeIterator.next();

                if (currentPalindrome.endIndex==currentIndex - 1) {

                    if (currentPalindrome.getSize()==1) {
                        currentPalindrome.endIndex = currentIndex;
                        if (currentPalindrome.getStartChar(input)==currentPalindrome.getEndChar(input)) {
                            //we've found a minimal 2-char palindrome
                            currentPalindrome.candidate = false;
                        }
//                        log.info("Updating to palindrome: {}", currentPalindrome);
                    } else if (currentPalindrome.getSize()==2) {
                        boolean alreadyReplaced = false;
                        if (currentPalindrome.getStartChar(input)==currentChar) {
                            //odd palindrome core found
                            palindromeIterator.remove();
                            Palindrome newPalindrome = new Palindrome(currentPalindrome.startIndex, currentIndex, false);
                            palindromeIterator.add(newPalindrome);
                            alreadyReplaced = true;
//                            log.info("Adding palindrome: {}", newPalindrome);
                        }
                        if (currentPalindrome.startIndex > 0 && (input.get(currentPalindrome.startIndex - 1)==currentChar
                                && currentPalindrome.getStartChar(input)==currentPalindrome.getEndChar(input))) {
                            //even palindrome core found
                            if (!alreadyReplaced) {
                                palindromeIterator.remove();
                            }
                            Palindrome newPalindrome = new Palindrome(currentPalindrome.startIndex - 1, currentIndex, false);
                            palindromeIterator.add(newPalindrome);
//                            log.info("Adding palindrome: {}", newPalindrome);
                        }
                    } else {
                        if (currentPalindrome.startIndex > 0 && (input.get(currentPalindrome.startIndex - 1)==currentChar)) {
                            //bigger palindrome found
                            currentPalindrome.startIndex = currentPalindrome.startIndex - 1;
                            currentPalindrome.endIndex = currentIndex;
                            currentPalindrome.candidate = false;
//                            log.info("Updating to palindrome: {}", currentPalindrome);
                        }
                    }
                }
            }

            palindromes.add(new Palindrome(currentIndex));
        }

        return palindromes.stream().filter(palindrome -> !palindrome.candidate || palindrome.getSize()==1).max(Comparator.comparing(Palindrome::getSize)).map(palindrome -> s.substring(palindrome.startIndex, palindrome.endIndex + 1)).orElse("");
    }

    private class Palindrome {

        private int startIndex;
        private int endIndex;
        private boolean candidate;

        public Palindrome(int startIndex) {
            this.startIndex = startIndex;
            this.endIndex = startIndex;
            this.candidate = true;
        }

        public Palindrome(int startIndex, int endIndex, boolean candidate) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.candidate = candidate;
        }

        private int getSize() {
            return endIndex - startIndex + 1;
        }

        private char getStartChar(List<Character> input) {
            return input.get(startIndex);
        }

        private char getEndChar(List<Character> input) {
            return input.get(endIndex);
        }

        @Override
        public String toString() {
            return original.substring(startIndex, endIndex + 1);
        }
    }

}
