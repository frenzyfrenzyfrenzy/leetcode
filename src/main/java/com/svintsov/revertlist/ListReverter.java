package com.svintsov.revertlist;

import java.util.Objects;

public class ListReverter {

    public <T> Node<T> revert(Node<T> input) {

        Node<T> revertedHead = null;
        Node<T> restToRevert = input;

        while (Objects.nonNull(restToRevert)) {
            Node<T> next = restToRevert.getNext();
            restToRevert.setNext(revertedHead);
            revertedHead = restToRevert;
            restToRevert = next;
        }

        return revertedHead;
    }

}
