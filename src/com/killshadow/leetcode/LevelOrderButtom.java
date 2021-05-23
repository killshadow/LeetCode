package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

import java.util.*;

public class LevelOrderButtom {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 使用双向队列(栈),每层遍历完成,都往栈顶添加列表
        Deque<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>(res);
        }
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 如果队列不为空,则继续循环
        while (!queue.isEmpty()) {
            // 取出队列的大小, 这个大小表示二叉树每层的节点数
            int size = queue.size();
            // 用来存储每层节点值
            List<Integer> tmpLevel = new ArrayList<>();
            // 遍历该层所有的节点, 并把这些节点对应的子节点加入到队列中
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                tmpLevel.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // 往栈顶(队首)添加元素
            res.offerFirst(tmpLevel);
        }
        // 将双向队列转成列表.
        return new ArrayList<>(res);
    }
}
