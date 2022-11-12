package com.svintsov.listswap;

import java.util.Objects;

public class ListSwap {

    public ListNode swapPairs(ListNode head) {
        return swapNext(head, null);
    }

    private ListNode swapNext(ListNode head, ListNode previous) {

        ListNode firstToSwap = Objects.isNull(previous) ? head : previous.next;
        if (Objects.isNull(firstToSwap)) {
            return head;
        }

        ListNode secondToSwap = firstToSwap.next;
        if (Objects.isNull(secondToSwap)) {
            return head;
        }

        ListNode next = secondToSwap.next;
        secondToSwap.next = firstToSwap;
        firstToSwap.next = next;
        if (Objects.nonNull(previous)) {
            previous.next = secondToSwap;
        }

        ListNode newHead = Objects.isNull(previous) ? secondToSwap : head;
        return swapNext(newHead, firstToSwap);
    }

}
