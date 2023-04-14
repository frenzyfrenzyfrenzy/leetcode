package com.svintsov.revertlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListReverterTest {

    private ListReverter listReverter;

    @BeforeEach
    public void beforeEach() {
        listReverter = new ListReverter();
    }

    @Test
    public void listReverterTest() {
        Node<Integer> head = Node.fromList(List.of(1, 2, 3, 4));
        Node.print(head);
        System.out.println("----------");
        Node<Integer> revertedHead = listReverter.revert(head);
        Node.print(revertedHead);
    }

    @Test
    public void recursiveListReverterTest() {
        Node<Integer> head = Node.fromList(List.of(1, 2, 3, 4));
        Node.print(head);
        System.out.println("----------");
        Node<Integer> revertedHead = listReverter.revertRecursive(head);
        Node.print(revertedHead);
    }

}