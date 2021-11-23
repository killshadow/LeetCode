package com.killshadow.leetcode;

import java.util.*;

/**
 * User: killshadow
 * Date: 2021/10/29 0029
 * Description:
 */
public class MinMeetingRooms {
    public static void main(String[] args) {
        MinMeetingRooms rooms = new MinMeetingRooms();
        System.out.println(rooms.minMeetingRooms(new int[][]{{1, 8}, {6, 20}, {9, 16}, {13, 17}})); // 3
        System.out.println(rooms.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}})); // 2
        System.out.println(rooms.minMeetingRooms(new int[][]{{7, 10}, {2, 4}})); // 1
        System.out.println(rooms.minMeetingRooms(new int[][]{{13, 15}, {1, 13}})); // 1
    }

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] val : intervals) {
            list.add(new int[]{val[0], 1});
            list.add(new int[]{val[1], -1});
        }
        list.sort((a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int ans = 0;
        int sum = 0;
        for (int[] val : list) {
            sum += val[1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
