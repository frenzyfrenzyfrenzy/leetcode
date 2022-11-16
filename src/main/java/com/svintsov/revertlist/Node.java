package com.svintsov.revertlist;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
public class Node<T> {

    private T value;
    private Node<T> next;

    public static <E> Node<E> fromList(List<E> list) {
        Node<E> previous = null;
        Node<E> head = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            head = new Node<>(list.get(i), previous);
            previous  = head;
        }
        return head;
    }

    public static <E> void print(Node<E> head) {
        while (Objects.nonNull(head)) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

}
