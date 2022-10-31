package com.svintsov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomListQueueTest {

    private CustomListQueue<Integer> customQueue;

    @BeforeEach
    public void beforeEach() {
        customQueue = new CustomListQueue<>();
    }

    @Test
    public void testCustomQueue_1() {
        customQueue.add(1);
        customQueue.add(2);
        customQueue.add(3);
        System.out.println(customQueue.size());
        System.out.println(customQueue.get());
        System.out.println(customQueue.get());
        System.out.println(customQueue.get());
        System.out.println(customQueue.size());
    }

}