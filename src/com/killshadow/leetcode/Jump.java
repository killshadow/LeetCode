package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class Jump {
    public static void main(String[] args) {
        Jump jump45 = new Jump();
        System.out.println(jump45.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump45.jump(new int[]{2, 3, 0, 1, 4}));
    }

    /**
     * 贪心算法,求每步能到达最远的节点
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int maxPath = 0;
        int stop = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPath = Math.max(maxPath, i + nums[i]);
            if (i == stop) {
                stop = maxPath;
                step++;
            }
        }
        return step;
    }
}
