package com.svintsov.kthsmallest;

import static org.junit.jupiter.api.Assertions.*;

import com.svintsov.kthsmallest.Solution.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void beforeEach() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode _00 = new TreeNode(6);

        TreeNode _10 = new TreeNode(3);

        TreeNode _20 = new TreeNode(2);
        TreeNode _30 = new TreeNode(1);
        TreeNode _21 = new TreeNode(4);

        TreeNode _11 = new TreeNode(9);

        TreeNode _22 = new TreeNode(7);
        TreeNode _23 = new TreeNode(10);

        _00.left = _10;
        _00.right = _11;

        _10.left = _20;
        _10.right = _21;

        _20.left = _30;

        _11.left = _22;
        _11.right = _23;

        System.out.println(solution.kthSmallest(_00, 1));
        System.out.println(solution.kthSmallest(_00, 2));
        System.out.println(solution.kthSmallest(_00, 3));
        System.out.println(solution.kthSmallest(_00, 4));
        System.out.println(solution.kthSmallest(_00, 5));
        System.out.println(solution.kthSmallest(_00, 6));
        System.out.println(solution.kthSmallest(_00, 7));
        System.out.println(solution.kthSmallest(_00, 8));
    }

}