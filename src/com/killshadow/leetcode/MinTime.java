package com.killshadow.leetcode;

import com.killshadow.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.*;

/**
 * User: killshadow
 * Date: 2021/11/23 0023
 * Description:
 */
public class MinTime {
    public static void main(String[] args) {
        int[][] edges = Utils.stringToInt2dArray("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        Boolean[] hasApple = {false, false, true, false, true, true, false};
        MinTime minTime = new MinTime();
        System.out.println(minTime.minTime(7, edges, Arrays.asList(hasApple)));
    }

    int ans = Integer.MAX_VALUE;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int ans = 0;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> list = map.getOrDefault(edge[0], new HashSet<>());
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        return ans;
    }

    private void dfs(Map<Integer,Set<Integer>> node, List<Boolean> hasApple, )
}
