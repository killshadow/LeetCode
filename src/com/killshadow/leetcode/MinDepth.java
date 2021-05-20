package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 1. BFS核心数据结构, 用来存储每层的所有节点.
        Queue<TreeNode> nodes = new LinkedList<>();
        // 2. 记录扩散的深度/步数.
        int depth = 1;
        // 3. 将起点加入队列.
        nodes.offer(root);

        // 4. 每一次while循环代表一层.
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            // 5. 遍历队列里所有的节点, 每遍历一次将队列里的节点取出, 并把该节点的子节点放入队列.
            for (int i = 0; i < size; i++) {
                TreeNode current = nodes.poll();
                // 6. 判断是否到达终点, 如果子节点都为空, 则表示到了叶子节点, 返回深度.
                if (current.left == null && current.right == null) {
                    return depth;
                }
                // 7. 将所有子节点都加入到队列中, 在下一次while循环时取出这些子节点.
                if (current.left != null) {
                    nodes.offer(current.left);
                }
                if (current.right != null) {
                    nodes.offer(current.right);
                }
            }
            // 8. 更新扩散的深度/步数.
            depth++;
        }
        return depth;
    }
}
