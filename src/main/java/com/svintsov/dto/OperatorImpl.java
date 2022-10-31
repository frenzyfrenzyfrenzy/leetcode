package com.svintsov.dto;

import static com.svintsov.dto.Associativity.LEFT;
import static com.svintsov.dto.Associativity.RIGHT;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum OperatorImpl implements Operator {

    LB("(", null, null),
    RB(")", null, null),
    PLUS("+", 0, LEFT),
    MINUS("-", 0, LEFT),
    DIVIDE("/", 1, LEFT),
    MULTIPLY("*", 1, LEFT),
    POWER("^", 2, RIGHT),
    ;

    private final String stringValue;
    private final Integer precedence;
    private final Associativity associativity;

    public static Optional<OperatorImpl> fromString(String value) {
        return Arrays.stream(values())
                .filter(operator -> operator.getStringValue().equals(value))
                .findFirst();
    }


    @Override
    public String toString() {
        return stringValue;
    }
}
