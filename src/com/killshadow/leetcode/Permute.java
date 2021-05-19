package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        List<List<Integer>> res = new Permute().permute(new int[]{1, 3, 5});
        res.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
    public List<List<Integer>> permute(int[] nums) {
        // 返回最终的排列组合
        List<List<Integer>> ret = new ArrayList<>();
        // 路径选择列表
        List<Integer> trace = new ArrayList<>();
        // 路径访问数组, 初始化所有节点都未访问
        boolean[] visited = new boolean[nums.length + 1];
        Arrays.fill(visited, false);
        backtrack(nums, visited, ret, trace);
        return ret;
    }

    /**
     * 回溯算法核心三要素: 1. 路径(trace); 2. 选择列表(visited); 3. 结束条件(首行判断).
     *
     * @param nums
     * @param visited
     * @param ret
     * @param trace
     */
    private void backtrack(int[] nums, boolean[] visited, List<List<Integer>> ret, List<Integer> trace) {
        // 1. 路径结束条件: 当路径长度和总的节点数相等时, 说明路径包含了所有元素, 这是一个完整的排列, 加入到返回列表中.
        if (trace.size() == nums.length) {
            ret.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 2. 先判断是否在选择列表中, 如果被访问过, 则无需再访问, 直接continue.
            if (visited[i]) {
                continue;
            }
            // 3.1 做选择, 并标记访问状态为访问过.
            visited[i] = true;
            // 3.2 做选择, 将该元素加入路径中.
            trace.add(nums[i]);
            // 4. 进一步遍历其他元素
            backtrack(nums, visited, ret, trace);
            // 5.1 撤销选择
            trace.remove(trace.size() - 1);
            // 5.2 撤销访问记录
            visited[i] = false;
        }
    }
}
