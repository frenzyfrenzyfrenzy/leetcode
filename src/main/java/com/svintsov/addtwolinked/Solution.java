package com.svintsov.addtwolinked;

import static java.util.Objects.isNull;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode resultTail = null;

        ListNode currentFirstHead = l1;
        ListNode currentSecondHead = l2;
        int carryOver = 0;
        while (!(isNull(currentFirstHead) && isNull(currentSecondHead) && carryOver == 0)) {

            int currentFirstValue = isNull(currentFirstHead) ? 0 : currentFirstHead.val;
            int currentSecondValue = isNull(currentSecondHead) ? 0 : currentSecondHead.val;

            int currentSum = currentFirstValue + currentSecondValue + carryOver;
            if (currentSum / 10 > 0) {
                currentSum = currentSum % 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }

            if (isNull(resultHead)) {
                resultHead = new ListNode(currentSum);
            } else {
                if (isNull(resultTail)) {
                    resultTail = new ListNode(currentSum);
                    resultHead.next = resultTail;
                } else {
                    ListNode newResultTail = new ListNode(currentSum);
                    resultTail.next = newResultTail;
                    resultTail = newResultTail;
                }
            }

            currentFirstHead = isNull(currentFirstHead) ? null : currentFirstHead.next;
            currentSecondHead = isNull(currentSecondHead) ? null : currentSecondHead.next;
        }

        return resultHead;
    }

}
