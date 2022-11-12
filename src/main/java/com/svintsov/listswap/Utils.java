package com.svintsov.listswap;

import java.util.List;
import java.util.Objects;

public class Utils {

    public static void printList(ListNode head) {
        if (Objects.isNull(head)) {
            return;
        }
        System.out.println(head.val);
        printList(head.next);
    }

    public static ListNode fromList(List<Integer> list) {
        ListNode next = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            next = new ListNode(list.get(i), next);
        }
        return next;
    }

}
