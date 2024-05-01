package com.svintsov.validatebst;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        List<Integer> numbers = toList(root);
        int current;
        Integer previous = null;
        for (Integer number : numbers) {
            current = number;
            if (isNull(previous) || current > previous) {
                previous = current;
            } else {
                return false;
            }
        }
        return true;
    }

    private List<Integer> toList(TreeNode tree) {
        if (isNull(tree)) {
            return new ArrayList<>();
        }
        List<Integer> allValues = toList(tree.left);
        allValues.add(tree.val);
        allValues.addAll(toList(tree.right));
        return allValues;
    }

}
