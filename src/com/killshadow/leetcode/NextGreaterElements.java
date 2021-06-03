package com.killshadow.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        NextGreaterElements elements503 = new NextGreaterElements();
        System.out.println(Arrays.toString(elements503.nextGreaterElements(nums)));
        System.out.println(Arrays.toString(elements503.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(elements503.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        int index = 0;
        while (index < 2 * len - 1) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[index % len]) {
                ans[stack.pollLast()] = nums[index % len];
            }
            stack.offerLast(index++ % len);
        }

        return ans;
    }
}
