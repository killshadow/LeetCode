package com.killshadow.leetcode;

public class MaxEqualFreq {
    public static void main(String[] args) {
//        int[] input = new int[]{2, 2, 1, 1, 5, 3, 3, 5};
        int[] input = new int[]{1, 1, 1, 1, 1, 1, 1};
        System.out.println(new MaxEqualFreq().maxEqualFreq(input));

    }

    /**
     * 假设子数组中, 频数有两种情况时, 频率分别为A和B, 分4种情况:
     * 1. 子数组元素频数只有两种情况, 频率A-1=B, 即A多出了一个.
     *      例如: [1,1,1,2,2,3,3,4,4], A=3,B=2, 该数组长度为:
     *      B(次高频元素出现的频数, 这里次高频数为2)*频数为B的个数(频数为B的元素个数, 这里有4种元素)
     * 2. 子数组元素频数只有两种情况, 频率A=n(n为任意正整数), B=1.
     *      例如: [1,1,1,1,1,1,2]或[1,1,1,2,2,2,4], 该数组长度为: 频数*A(高频元素的个数) + 1
     * 3. 子数组元素频数都只出现1次, 所有元素的频率都为1, 即: A=B=1.
     *      例如: [1,2,3,4,5,6], 该数组长度为nums.length
     * 4. 子数组元素都相同.
     *      例如: [1,1,1,1,1,1]
     *
     * 假设sum[i]为子数组元素i出现的频数(个数),cnt[j]为频数j出现的个数,
     * max{max = Math.max(sum[i], max)}为当前最高频元素的个数,
     * 则这4种情况分别有(i在下面为nums的index, {}括号里的为解释部分):
     * 1. (max-1)*cnt[max-1] + 1{A-B=1} == i + 1{i+1为当前子数组的长度} && cnt[max] == 1{最高频元素只有1个}
     * 2. cnt[max]*max + 1{单独出现的一个元素} == i + 1{i+1为当前子数组的长度}
     * 3. max 恒等于 1
     * 4. max == nums.length, 与第一种情况相同
     */
    public int maxEqualFreq(int[] nums) {
        int len = nums.length;
        int[] sum = new int[100001];
        int[] cnt = new int[100001];
        int max = 0;
        int res = 0;

        for (int i = 0; i < len; i++) {
            cnt[++sum[nums[i]]]++;
            max = Math.max(sum[nums[i]], max);

            if (((max - 1) * cnt[max - 1] + 1 == i + 1) && (cnt[max] == 1) ||
                    (cnt[max]*max + 1) == (i + 1)) {
                res = i + 1;
            }
        }

        if (max == 1) {
            return len;
        }

        return res;
    }
}