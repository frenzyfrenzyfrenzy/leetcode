package com.svintsov.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CutoffSearchTest {

    private CutoffSearch cutoffSearch;

    @BeforeEach
    public void beforeEach() {
        cutoffSearch = new CutoffSearch();
    }

    @Test
    public void searchGreaterOrEqualTest() {
        assertThat(cutoffSearch.searchGreaterOrEqualCount(new int[]{1, 3, 5, 7, 9}, 6)).isEqualTo(2);
        assertThat(cutoffSearch.searchGreaterOrEqualCount(new int[]{1, 3, 5, 7, 9, 9}, 6)).isEqualTo(3);
        assertThat(cutoffSearch.searchGreaterOrEqualCount(new int[]{3, 3, 3, 3, 3, 3}, 1)).isEqualTo(6);
    }

}