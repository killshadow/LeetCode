package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isOrderRight = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> tmpLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (isOrderRight) {
                    tmpLevel.offerLast(current.val);
                } else {
                    tmpLevel.offerFirst(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            isOrderRight = !isOrderRight;
            res.add(new ArrayList<>(tmpLevel));
        }
        return res;
    }
}
