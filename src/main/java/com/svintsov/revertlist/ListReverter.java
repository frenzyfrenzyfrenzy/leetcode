package com.svintsov.revertlist;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ListReverter {

    public <T> Node<T> revert(Node<T> input) {

        Node<T> restHead = input;
        Node<T> revertedHead = null;

        while (nonNull(restHead)) {
            Node<T> nextRestHead = restHead.getNext();
            restHead.setNext(revertedHead);
            revertedHead = restHead;
            restHead = nextRestHead;
        }

        return revertedHead;
    }

    public <T> Node<T> revertRecursive(Node<T> root) {
        Node<T> secondElement = root.getNext();
        if (isNull(secondElement)) {
            return root;
        }
        Node<T> revertedTail = revertRecursive(secondElement);
        secondElement.setNext(root);
        root.setNext(null);
        return revertedTail;
    }

}
