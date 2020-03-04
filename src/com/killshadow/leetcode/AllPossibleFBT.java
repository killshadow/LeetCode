package com.killshadow.leetcode;


import java.util.HashMap;
import java.util.LinkedList;

import com.killshadow.utils.TreeNode;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
    public static void main(String[] args) {

        System.out.println(allPossibleFBT(7));

    }

    static HashMap<Integer, List<TreeNode>> ret = new HashMap<>();
    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> nodes = new LinkedList<>();
        if (ret.containsKey(N)) {
            return ret.get(N);
        }

        if (N == 1) {
            nodes.add(new TreeNode(0));
        }

        if (N % 2 == 1) {
            for (int i = 0; i < N; ++i) {
                int j = N - 1 - i;
                for (TreeNode leftNode : allPossibleFBT(i)) {
                    for (TreeNode rightNode : allPossibleFBT(j)) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = leftNode;
                        tmp.right = rightNode;
                        nodes.add(tmp);
                    }
                }
            }
        }

        ret.put(N, nodes);

        return ret.get(N);
    }
}

class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}

/*
*
* 如果你要构造一颗有 N 个节点的二叉树，你会怎么做？

首先，你肯定会先 new 一个根结点对象 root，然后为它构造左子树，再为它构造右子树。

那么对它的左子树 root.left 而言，它同样需要构造左子树和右子树。右子树 root.right 亦然。

因此，你的所有子树都是一棵满二叉树。

「给你一个整数 N，构造出一棵包含 N 个节点的满二叉树」。这句话是题目本身，也是无数个被拆分出的子问题。

* 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

如果你要为某节点分配一个左节点，那么一定也要为它分配一个右节点。因此，如果 N 为偶数，那一定无法构成一棵满二叉树。

为了列出所有满二叉树的排列，我们可以为左子树分配 x 节点，为右子树分配 N - 1 - x（其中减 1 减去的是根节点）节点，然后递归地构造左右子树。

x 的数目从 1 开始，每次循环递增数目 2（多增加 2 个节点，等于多增加 1 层）。
*
*
*对于这个问题来说，结束条件为：

当 N 为偶数时：无法构造满二叉树，返回空数组
当 N == 1 时：树只有一个节点，直接返回包含这个节点的数组
当完成 N 个节点满二叉树构造时：返回结果数组

*/