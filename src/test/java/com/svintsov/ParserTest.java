package com.svintsov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserTest {

    private Parser parser;

    @BeforeEach
    public void beforeEach() {
        parser = new Parser();
    }

    @Test
    public void testParse_1() {
        parser.parse("(123*345-12)+4325+(12/5)");
    }

}