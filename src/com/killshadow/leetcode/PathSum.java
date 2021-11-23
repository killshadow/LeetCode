package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * User: killshadow
 * Date: 2021/9/15 0015
 * Description:
 */
public class PathSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> trace = new LinkedList<>();
        dfs(root, targetSum, trace, ans);
        return ans;
    }

    public void dfs(TreeNode node, int targetSum, Deque<Integer> trace, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        targetSum -= node.val;
        trace.offerLast(node.val);
        if (node.left == null && node.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(trace));
        }
        dfs(node.left, targetSum, trace, ans);
        dfs(node.right, targetSum, trace, ans);
        trace.pollLast();
    }
}
