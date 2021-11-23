package com.killshadow.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * User: killshadow
 * Date: 2021/11/13 0013
 * Description:
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow window = new MaxSlidingWindow();
        // 3,3,5,5,6,7
        System.out.println(Arrays.toString(window.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); //
        // 1
        System.out.println(Arrays.toString(window.maxSlidingWindow(new int[]{1}, 1)));
        // 1,-1
        System.out.println(Arrays.toString(window.maxSlidingWindow(new int[]{1, -1}, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // idx, num
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{i, nums[i]});
        }

        ans[0] = queue.peek()[1];
        int right = k;
        while (right < len) {
            queue.offer(new int[]{right, nums[right]});
            while (!queue.isEmpty() && queue.peek()[0] < right - k + 1) {
                queue.poll();
            }
            ans[right - k + 1] = queue.peek()[1];
            right++;
        }
        return ans;
    }
}
