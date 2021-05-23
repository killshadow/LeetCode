package com.killshadow.leetcode;

import com.killshadow.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i < size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            queue.peek().next = null;
            int size = queue.size();
            Node preNode = null;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (preNode != null) {
                    preNode.next = current;
                }
                preNode = current;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
        }
        return root;
    }
}
