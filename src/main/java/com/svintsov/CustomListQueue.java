package com.svintsov;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CustomListQueue<T> {

    private Node<T> tail;
    private Node<T> head;
    private int size = 0;

    public CustomListQueue() {
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (size == 0) {
            tail = newNode;
            head = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T get() {

        if (size == 0) {
            throw new IllegalArgumentException();
        }

        Node<T> toReturn = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;

        return toReturn.getValue();
    }

    public int size() {
        return size;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Node<T> {

        private T value;
        private Node<T> next;

    }

}
