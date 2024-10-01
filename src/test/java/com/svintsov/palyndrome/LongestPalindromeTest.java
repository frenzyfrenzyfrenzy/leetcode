package com.svintsov.palyndrome;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class LongestPalindromeTest {

    private Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void test() {
/*        log.info(solution.longestPalindrome(""));
        log.info(solution.longestPalindrome("c"));
        log.info(solution.longestPalindrome("ccc"));
        log.info(solution.longestPalindrome("aacccaa"));
        log.info(solution.longestPalindrome("aaccccaa"));
        log.info(solution.longestPalindrome("acccb"));
        log.info(solution.longestPalindrome("abba"));
        log.info(solution.longestPalindrome("cabbad"));*/
        log.info(solution.longestPalindrome("aacabdkacaa"));
    }

}