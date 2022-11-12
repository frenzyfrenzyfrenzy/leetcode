package com.svintsov.listswap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListSwapTest {

    private ListSwap listSwap;

    @BeforeEach
    public void beforeEach() {
        listSwap = new ListSwap();
    }

    @Test
    public void listSwapTest_0() {
        Utils.printList(Utils.fromList(List.of(1,2,3,4,5)));
        System.out.println("--------------------------");
        Utils.printList(Utils.fromList(List.of(1)));
        System.out.println("--------------------------");
        Utils.printList(Utils.fromList(List.of()));
    }

    @Test
    public void listSwapTest_1() {
        Utils.printList(listSwap.swapPairs(Utils.fromList(List.of(1,2,3,4,5))));
        System.out.println("--------------------------");
        Utils.printList(listSwap.swapPairs(Utils.fromList(List.of(1,2,3,4))));
        System.out.println("--------------------------");
        Utils.printList(listSwap.swapPairs(Utils.fromList(List.of(1))));
        System.out.println("--------------------------");
        Utils.printList(listSwap.swapPairs(Utils.fromList(List.of())));
        System.out.println("--------------------------");
    }

}