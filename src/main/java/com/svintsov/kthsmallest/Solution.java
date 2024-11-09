package com.svintsov.kthsmallest;

import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    public int kthSmallest(TreeNode root, int k) {
        return visit(root, new AtomicInteger(-1), k);
    }

    private Integer visit(TreeNode currentNode, AtomicInteger currentOrder, int orderToFind) {
        Integer result;
        if (currentNode.left != null) {
            result = visit(currentNode.left, currentOrder, orderToFind);
            if (result != null) {
                return result;
            }
        }
        if (currentOrder.get() == -1) {
            currentOrder.set(1);
        } else {
            currentOrder.incrementAndGet();
        }
        if (currentOrder.get() == orderToFind) {
            return currentNode.val;
        }
        if (currentNode.right != null) {
            result = visit(currentNode.right, currentOrder, orderToFind);
            return result;
        }
        return null;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
