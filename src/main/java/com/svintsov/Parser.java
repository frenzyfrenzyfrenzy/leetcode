package com.svintsov;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern startOfElementPattern = Pattern.compile("[\\d\\(\\)+\\-\\^*/]");
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    public List<String> parse(String input) {
        input = input.replaceAll("\\s", "");
        Matcher startOfElementMatcher = startOfElementPattern.matcher(input);
        Matcher numberMatcher = numberPattern.matcher(input);
        int startFrom = 0;
        List<String> result = new ArrayList<>();
        while (startOfElementMatcher.find(startFrom)) {
            String found = startOfElementMatcher.group();
            if (found.matches("\\d")) {
                numberMatcher.find(startOfElementMatcher.start());
                String foundNumber = numberMatcher.group();
                result.add(foundNumber);
                startFrom = numberMatcher.end();
            } else {
                result.add(found);
                startFrom = startOfElementMatcher.end();
            }
        }
        return result;
    }

}

