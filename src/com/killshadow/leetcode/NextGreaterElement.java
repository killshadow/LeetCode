package com.killshadow.leetcode;

import java.util.*;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement element = new NextGreaterElement();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(element.nextGreaterElement(nums1, nums2)));
    }

    /**
     * 单调栈: 先通过单调栈(单调递减)来确定该数值的下一个大于该值的数,
     * 再通过Map来保存上面这个关系.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.pollLast(), nums2[i]);
            }
            stack.offerLast(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            ans[j] = map.getOrDefault(nums1[j], -1);
        }
        return ans;
    }
}
