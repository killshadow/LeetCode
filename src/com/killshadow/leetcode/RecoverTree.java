package com.killshadow.leetcode;

import com.killshadow.utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
中序遍历过程中，记录错误两个错误排序节点，最后进行交换
只需要中序遍历一遍就可以了

首先我们来看中序遍历过程模板
public void inorder(TreeNode root){
        if (root == null) return ;    //终止条件
        inorder(root.left);           //访问左子树
        对当前节点进行一些操作          //访问根节点-----在遍历过程中希望实现的操作
        inorder(root.right);          //访问右子树
    }

另一方面我们知道 对二叉搜索树进行 中序遍历的时候 访问到的元素是从小到大顺序排列的
如我们对实例 2 恢复好的树 进行中序遍历 得到的应该是  1 2 3 4

那这道题我们就有了大致思路
我们对错误的二叉树进行 中序遍历 那我们按顺序访问到的数应该是按顺序排列的
那如果对两个节点交换了顺序  那一定有两个地方是  不满足  前一个元素 < 当前元素 < 后一个元素
 如示例2      3  1  4   2：
              3  这个节点不满足      1 这个节点不满足
             所以我们使用两个全局变量在遍历过程中记录这两个节点 最后对他们进行交换


如下图所示，中序遍历顺序是 4,2,3,1，我们只要找到节点 4 和节点 1 交换顺序即可！
这里我们有个规律发现这两个节点：
第一个节点，是第一个按照中序遍历时候前一个节点大于后一个节点，我们选取前一个节点，这里指节点 4；
第二个节点，是在第一个节点找到之后，后面出现前一个节点大于后一个节点，我们选择后一个节点，这里指节点 1；
https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
 */

class RecoverTree {
    TreeNode pre, firstNode, secondNode;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null && firstNode == null && pre.val > node.val) firstNode = pre;
        if (pre != null && firstNode != null && pre.val > node.val) secondNode = node;
        pre = node;
        inOrder(node.right);
    }
}
