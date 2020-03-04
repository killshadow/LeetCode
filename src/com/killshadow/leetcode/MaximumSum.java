package com.killshadow.leetcode;

public class MaximumSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 0, 3};
        System.out.println(new MaximumSum().maximumSum(arr));
    }

    public int maximumSum(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        int[] func = new int[len];
        int[] gen = new int[len];
        int ans = -20001;
        func[0] = arr[0];
        gen[0] = ans;
        for (int i = 1; i < len; i++) {
            func[i] = Math.max(func[i - 1] + arr[i], arr[i]);
            gen[i] = Math.max(gen[i - 1] + arr[i], func[i - 1]);
            ans = Math.max(ans, Math.max(func[i], gen[i]));
        }
        return ans;
    }
}
