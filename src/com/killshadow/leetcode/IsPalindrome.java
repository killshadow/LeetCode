package com.killshadow.leetcode;

import java.util.Stack;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        long a = 0, b = 0,k = 1;
        if (head != reverseListNode(head)) {
            return false;
        }
        return true;
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

//    def isPalindrome(self, head):
//        s1=0
//        s2=0
//        t=1
//
//        while head!=None:
//        s1=s1*10+head.val
//        s2=s2+t*head.val
//        t=t*10
//        head=head.next
//
//        return s1==s2
// s1 = s1*10 + head.val;
//         s2 = s2 + t*head.val;
//         t = t*10;
//         head = head.next;

//private class Solution {
//    public boolean isPalindrome(ListNode head) {
//        if(head == null || head.next == null) return true;
//        ListNode slow = head, fast = head.next, pre = null, prepre = null;
//        while(fast != null && fast.next != null) {
//            //反转前半段链表
//            pre = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//            //先移动指针再来反转
//            pre.next = prepre;
//            prepre = pre;
//        }
//        ListNode p2 = slow.next;
//        slow.next = pre;
//        ListNode p1 = fast == null? slow.next : slow;
//        while(p1 != null) {
//            if(p1.val != p2.val)
//                return false;
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return true;
//    }
//}


/*
 * 输入: 1->2->2->1
 * 输出: true
 * */