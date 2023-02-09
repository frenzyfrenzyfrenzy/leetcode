package com.svintsov.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    public void beforeEach() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void binarySearchTest() {
        assertThat(binarySearch.searchBinary(new int[]{1, 1, 1, 4, 5}, 4)).isEqualTo(Optional.of(3));
        assertThat(binarySearch.searchBinary(new int[]{1, 2, 2, 2, 2}, 1)).isEqualTo(Optional.of(0));
        assertThat(binarySearch.searchBinary(new int[]{1, 2, 2, 2, 2}, 4)).isEqualTo(Optional.empty());
    }

}