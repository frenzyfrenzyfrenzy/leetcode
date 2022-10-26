package com.svintsov;

import static java.util.regex.Pattern.compile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Parser {

    public List<String> parse(String input) {
        List<String> parsed  = new ArrayList<>();
        Matcher nextCharacterMatcher = compile("[\\d\\(\\)+\\-\\*/]").matcher(input);
        Matcher numberMatcher = compile("\\d+").matcher(input);
        int startSearchAt = 0;
        while (nextCharacterMatcher.find(startSearchAt)) {
            String found = nextCharacterMatcher.group();
            if (found.matches("\\d")) {
                if (!numberMatcher.find(nextCharacterMatcher.start())) {
                    throw new IllegalArgumentException();
                }
                parsed.add(numberMatcher.group());
                startSearchAt = numberMatcher.end();
            } else {
                parsed.add(found);
                startSearchAt = nextCharacterMatcher.end();
            }
        }
        return parsed;
    }

}

