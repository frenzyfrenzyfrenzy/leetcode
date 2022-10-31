package com.svintsov;

import static java.lang.Integer.valueOf;

import com.svintsov.dto.Element;
import com.svintsov.dto.Operator;
import com.svintsov.dto.OperatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern startOfElementPattern = Pattern.compile("[\\d\\(\\)+\\-\\^*/]");
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    public List<String> parseString(String input) {
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

    public List<Element> parseToTyped(List<String> input) {
        return input.stream()
                .map(parsedElement -> {
                    Optional<OperatorImpl> operatorOpt = OperatorImpl.fromString(parsedElement);
                    return operatorOpt.map(Element::operator)
                            .orElseGet(() -> Element.number(valueOf(parsedElement)));
                })
                .collect(Collectors.toList());
    }

}

