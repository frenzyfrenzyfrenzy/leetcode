package com.svintsov.contaminatedtree;

import java.util.Objects;

class FindElements {

    private final TreeNode root;

    public FindElements(TreeNode root) {
        populateTreeNode(root, null);
        this.root = root;
    }

    public boolean find(int target) {
        return Objects.nonNull(findValue(root, target));
    }

    private TreeNode findValue(TreeNode node, int value) {
        if (node.val==value) {
            return node;
        }
        if (node.val > value) {
            return null;
        }
        if (Objects.nonNull(node.left)) {
            TreeNode leftFound = findValue(node.left, value);
            if (Objects.nonNull(leftFound)) {
                return leftFound;
            }
        }
        if (Objects.nonNull(node.right)) {
            TreeNode rightFound = findValue(node.right, value);
            if (Objects.nonNull(rightFound)) {
                return rightFound;
            }
        }
        return null;
    }

    private void populateTreeNode(TreeNode node, TreeNode parent) {
        if (Objects.isNull(parent)) {
            node.val = 0;
        } else if (node==parent.left) {
            node.val = 2 * parent.val + 1;
        } else if (node==parent.right) {
            node.val = 2 * parent.val + 2;
        }
        if (Objects.nonNull(node.left)) {
            populateTreeNode(node.left, node);
        }
        if (Objects.nonNull(node.right)) {
            populateTreeNode(node.right, node);
        }
    }

}
