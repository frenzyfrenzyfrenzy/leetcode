package com.svintsov;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverserTest {

    private Reverser reverser;

    @BeforeEach
    public void beforeEach() {
        reverser = new Reverser();
    }

    @Test
    public void testReverse_string_1() {
        char[] array = {'a', 'b', 'c'};
        reverser.reverseString(array, 0, array.length - 1);
        assertThat(array).containsExactly('c', 'b', 'a');
    }

    @Test
    public void testReverse_string_2() {
        char[] array = {'a', 'b', 'c', 'd'};
        reverser.reverseString(array, 0, array.length - 1);
        assertThat(array).containsExactly('d', 'c', 'b', 'a');
    }

    @Test
    public void testReverse_string_3() {
        char[] array = {'a'};
        reverser.reverseString(array, 0, array.length - 1);
        assertThat(array).containsExactly('a');
    }

    @Test
    public void testRevertInteger_1() {
        int result = reverser.reverseInteger(123);
        assertThat(result).isEqualTo(321);
    }

    @Test
    public void testRevertInteger_2() {
        int result = reverser.reverseInteger(3);
        assertThat(result).isEqualTo(3);
    }

}