package com.svintsov.reverseint;

class Solution {

    public int reverse(int x) {

        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }

        String stringRepresentation = String.valueOf(x);
        String reverted = revertString(stringRepresentation);
        try {
            int result = Integer.parseInt(reverted);
            if (isNegative) {
                result = -result;
            }
            return result;
        } catch (Exception exception) {
            return 0;
        }
    }

    private String revertString(String value) {
        char[] charArray = value.toCharArray();
        for (int i = 0; i <= charArray.length / 2 - 1; ++i) {
            int j = charArray.length - 1 - i;
            char t = charArray[j];
            charArray[j] = charArray[i];
            charArray[i] = t;
        }
        return new String(charArray);
    }

}
