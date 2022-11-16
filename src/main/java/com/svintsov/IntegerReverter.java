package com.svintsov;

public class IntegerReverter {

    private static final int base = 10;

    public void reverseString(char[] input, int start, int end) {
        if (end - start >= 1) {
            char tmp = input[end];
            input[end] = input[start];
            input[start] = tmp;
            reverseString(input, start + 1, end - 1);
        }
    }

    public int reverseInteger(int input) {

        int digit = 1;
        Integer digitValue = takeNthDigit(input, digit);
        while (digitValue != null) {
            digit++;
            digitValue = takeNthDigit(input, digit);
        }

        int oldDigit = digit - 1;
        int newDigit = 1;
        int result = 0;

        while (oldDigit != 0) {
            Integer oldDigitValue = takeNthDigit(input, oldDigit);
            result += ((int) Math.pow(base, newDigit - 1)) * oldDigitValue;
            oldDigit--;
            newDigit++;
        }

        return result;
    }

    private Integer takeNthDigit(int input, int digit) {

        int bigRemainder = input % ((int) Math.pow(base, digit));
        int smallRemainder = input % ((int) Math.pow(base, digit - 1));

        if (bigRemainder == smallRemainder) {
            return null;
        }

        return (bigRemainder - smallRemainder) / ((int) Math.pow(base, digit - 1));
    }

}
