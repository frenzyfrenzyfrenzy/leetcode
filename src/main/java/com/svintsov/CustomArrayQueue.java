package com.svintsov;

public class CustomArrayQueue<T> {

    private int writePosition = 0;
    private int readPosition = 0;
    private int size = 0;
    private final int capacity;
    private final T[] items;

    @SuppressWarnings("unchecked")
    public CustomArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
    }

    public void add(T value) {
        if (size == capacity) {
            throw new IllegalStateException();
        }
        items[writePosition] = value;
        writePosition = (writePosition + 1) % capacity;
        size++;
    }

    public T get() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        T toReturn = items[readPosition];
        readPosition = (readPosition + 1) % capacity;
        size--;
        return toReturn;
    }

    public int size() {
        return size;
    }

}
