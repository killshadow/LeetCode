package com.killshadow.leetcode;

import com.killshadow.utils.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = ListNode.stringToListNode(line);
            line = in.readLine();
            ListNode l2 = ListNode.stringToListNode(line);

            ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);

            String out = ListNode.listNodeToString(ret);

            System.out.print(out);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int flag = 0;
        ListNode listNode = new ListNode(0);
        ListNode p=l1, q=l2, current = listNode;
        while (p != null || q != null) {
            int result = (p != null ? p.val : 0) + ( q != null ? q.val : 0) + flag;

            if (p != null) p = p.next;
            if (q != null) q = q.next;

            current.next = new ListNode(result % 10);
            current = current.next;

            flag = result / 10;
        }

        if (flag > 0) current.next = new ListNode(flag);

        return listNode.next;
    }
}
