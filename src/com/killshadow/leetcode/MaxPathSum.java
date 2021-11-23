package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

/**
 * User: killshadow
 * Date: 2021/9/15 0015
 * Description:
 */
public class MaxPathSum {
    private int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 小于0的左子树直接舍弃,为0
        int left = Math.max(0, getMax(root.left));
        // 小于0的右子树直接舍弃,为0
        int right = Math.max(0, getMax(root.right));
        // 求当前左右子树和当前节点的值总和是否比最大值大
        ret = Math.max(ret, root.val + left + right);
        // 只能选左或有节点作为唯一的路径,所以这里取最大的节点作为下一步节点
        return Math.max(left, right) + root.val;
    }
}
