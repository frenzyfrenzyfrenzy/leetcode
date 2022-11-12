package com.svintsov.palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PalindromeParserTest {

    private PalindromeParser palindromeParser;

    @BeforeEach
    public void beforeEach() {
        palindromeParser = new PalindromeParser();
    }

    @Test
    public void testPalindromeParser_1() {
        List<Integer> parsed = palindromeParser.parseDigits(1);
        parsed.forEach(System.out::println);
    }

    @Test
    public void testPalindromeParser_2() {
        System.out.println(palindromeParser.isPalindrome(1221));
    }

}