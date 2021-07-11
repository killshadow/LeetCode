package com.killshadow.leetcode;

import java.io.IOException;

/**
 * User: killshadow
 * Date: 2021/7/11 0011
 * Description:
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0, head);
        ListNode curr = node;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while (curr.next != null && val == curr.next.val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return node.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    /**
     *
     * [1, 1, 1, 2, 3]
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode ret = deleteDuplicates.deleteDuplicates(stringToListNode("[1,2,3,3,4,4,5]"));
        System.out.print(listNodeToString(ret));
        ret = deleteDuplicates.deleteDuplicates(stringToListNode("[1,1,1,2,3]"));
        System.out.print(listNodeToString(ret));
    }
}
