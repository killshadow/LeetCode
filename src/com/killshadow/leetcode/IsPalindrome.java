package com.killshadow.leetcode;

import com.killshadow.utils.ListNode;
import com.killshadow.utils.NodeUtils;

import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
//        System.out.println(isPalindrome.isPalindrome(NodeUtils.stringToListNode("[1,2,2,1]")));
//        System.out.println(isPalindrome.isPalindrome(NodeUtils.stringToListNode("[1]")));
        System.out.println(isPalindrome.isPalindrome(NodeUtils.stringToListNode("[1,0,1]")));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (slow != null && fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null && !stack.isEmpty()) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
//        if (head != reverseListNode(head)) {
//            return false;
//        }
//        return true;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode listNode = new ListNode(0);
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        for (int i = 0; i < stack.size(); i++) {
            listNode.val = stack.pop();
            listNode = listNode.next;
        }
        return listNode;
    }
}

/*
 * 输入: 1->2->2->1
 * 输出: true
 * */