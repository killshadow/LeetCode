package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class MinEatingSpeed {
    public static void main(String[] args) {
        MinEatingSpeed speed = new MinEatingSpeed();
        System.out.println(speed.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(speed.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(speed.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }

    /**
     * 二分查找算法: 先找出拥有最多香蕉的一堆, 这个是速度的极大值. 然后, 速度的极小值就是1根/小时.
     * 所以, 在这个极小值和极大值之间, 就能使用二分法, 降低时间复杂度为 O(logN),再加上查询最大堆O(N),
     * 判断是否能够吃完O(N), 所以总的时间复杂度为O(N*logN)
     * 二分查找算法的核心是, 拥有一段连续的线性搜索空间, 在此基础上, 确定左右边界, 并根据变化的左右边界确定中点.
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPiles(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getMaxPiles(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public boolean canFinish(int[] piles, int speed, int time) {
        int total = 0;
        for (int pile : piles) {
            total += (int) Math.ceil((double) pile / speed);
        }
        return total <= time;
    }
}
