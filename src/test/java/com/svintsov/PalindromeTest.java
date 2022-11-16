package com.svintsov;

import com.svintsov.palindrome.RecurisvePalindrome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PalindromeTest {

    private RecurisvePalindrome palindrome;

    @BeforeEach
    public void beforeEach() {
        palindrome = new RecurisvePalindrome();
    }

    @Test
    public void testPalindrome_1() {
        List<Integer> result = palindrome.revert(1);
        System.out.println(result);
    }

}