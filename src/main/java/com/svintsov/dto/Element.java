package com.svintsov.dto;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Element {

    private final Operator operator;
    private final Integer number;

    public static Element operator(Operator operator) {
        return new Element(operator, null);
    }

    public static Element number(Integer number) {
        return new Element(null, number);
    }

    public boolean isNumber() {
        return nonNull(number);
    }

    @Override
    public String toString() {
        return isNumber() ? number.toString() : operator.toString();
    }
}
