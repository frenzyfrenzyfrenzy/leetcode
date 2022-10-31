package com.svintsov;

import org.junit.jupiter.api.Test;

class CustomArrayQueueTest {

    private CustomArrayQueue<Integer> customArrayQueue;

    @Test
    public void testCustomArrayQueue_1() {
        customArrayQueue = new CustomArrayQueue<>(3);
        customArrayQueue.add(1);
        customArrayQueue.add(2);
        customArrayQueue.add(3);
        System.out.println(customArrayQueue.get());
        System.out.println(customArrayQueue.get());
        System.out.println(customArrayQueue.get());
        customArrayQueue.add(4);
        customArrayQueue.add(5);
        customArrayQueue.add(6);
        System.out.println(customArrayQueue.get());
        System.out.println(customArrayQueue.get());
        System.out.println(customArrayQueue.get());
        System.out.println(customArrayQueue.get());
    }

}