package com.svintsov;

import com.svintsov.dto.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParserTest {

    private Parser parser;

    @BeforeEach
    public void beforeEach() {
        parser = new Parser();
    }

    @Test
    public void testParse_1() {
        List<String> result = parser.parseString("(123*345-12)+4325+(12/5)");
        result.forEach(System.out::println);
    }

    @Test
    public void testParseToTyped_1() {
        List<String> parsed = parser.parseString("(123*345-12)+4325+(12/5)^6");
        List<Element> result = parser.parseToTyped(parsed);
        result.forEach(System.out::println);
    }

    @Test
    public void testParseToPostfix_1() {
        List<String> parsed = parser.parseString("(123*345-12)+4325+(12/5)^6^7");
        List<Element> typed = parser.parseToTyped(parsed);
        List<Element> result = parser.parseToPostfix(typed);
        result.forEach(System.out::println);
    }

}