package com.svintsov;

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
        List<String> result = parser.parse("(123*345-12)+4325+(12/5)");
        result.forEach(System.out::println);
    }

}