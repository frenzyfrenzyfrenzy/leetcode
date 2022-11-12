package com.svintsov.intervals;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Interval {

    private final int beginning;
    private final int end;

    @Override
    public String toString() {
        return String.format("[%s,%s]", beginning, end);
    }
}
