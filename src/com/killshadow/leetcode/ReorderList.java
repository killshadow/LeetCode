package com.killshadow.leetcode;

import com.killshadow.utils.ListNode;

/**
 * User: killshadow
 * Date: 2021/7/28 0028
 * Description:
 */
public class ReorderList {
    public static void main(String[] args) {
//        midNode.next = newStart;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);
    }
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode fastPiont = head;
        ListNode slowPiont = fastPiont;
        while ((fastPiont.next.next != null) && (slowPiont.next != null)) {
            slowPiont = slowPiont.next;
            fastPiont = fastPiont.next.next;
        }
        ListNode midNode = slowPiont.next;
        ListNode startNode = null;
        slowPiont.next = null;
        while (midNode != null) {
            ListNode node = midNode.next;
            // 将前半部分头节点放到中间节点的下一节点
            midNode.next = startNode;
            // 将中间节点放到前半部分头节点
            startNode = midNode;
            // 递归遍历中间节点的下一节点
            midNode = node;
        }
        // 此时, 中间节点已经遍历到链表后半段的末尾
        midNode = startNode;


        ListNode newStart = head;
        while ((newStart != null) && (midNode != null)) {
            // 将头节点的下一节点
            ListNode node = newStart.next;
            ListNode tmp = midNode.next;
            newStart.next = midNode;
            newStart = node;
            midNode = tmp;
        }
    }
}
