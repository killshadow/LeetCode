package com.killshadow.leetcode;

import com.killshadow.utils.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoNumbers {
//    public static void main(String[] args) {
//        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//
//        int[] v1 = new int[]{2, 4, 3};
//        int[] v2 = new int[]{5, 6, 4};
//
//        ListNode l1 = null;
//        ListNode l2 = null;
//        for (int i = 0; i < v1.length; i++) {
//            l1 = new ListNode(v1[i]);
//            l2 = new ListNode(v2[i]);
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        for (int i = 0; i < v1.length; i++) {
//
//        }
//        ListNode ret = addTwoNumbers.addTwoNumbers(l1, l2);
//        while (ret != null) {
//            System.out.print(ret.val);
//            ret = ret.next;
//        }
//    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

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
