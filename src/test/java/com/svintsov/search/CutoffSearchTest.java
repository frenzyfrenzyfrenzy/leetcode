package com.svintsov.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class CutoffSearchTest {

    private CutoffSearch cutoffSearch;

    @BeforeEach
    public void beforeEach() {
        cutoffSearch = new CutoffSearch();
    }

    @Test
    public void searchGreaterOrEqualTest() {
        int position = cutoffSearch.countGreaterOrEqual(new int[]{1, 2, 3, 3, 100}, 3);
        log.info("{}", position);
    }

}