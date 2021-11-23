package com.killshadow.leetcode;

import com.killshadow.utils.Utils;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/11/13 0013
 * Description:
 */
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = Utils.stringToInt2dArray("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        WallsAndGates gates = new WallsAndGates();
        gates.wallsAndGates(rooms);
        Arrays.stream(rooms).forEach(arr -> System.out.println(Arrays.toString(arr)));

        rooms = new int[][]{{-1}};
        gates.wallsAndGates(rooms);
        Arrays.stream(rooms).forEach(arr -> System.out.println(Arrays.toString(arr)));

        rooms = new int[][]{{0}};
        gates.wallsAndGates(rooms);
        Arrays.stream(rooms).forEach(arr -> System.out.println(Arrays.toString(arr)));

        rooms = new int[][]{{Integer.MAX_VALUE}};
        gates.wallsAndGates(rooms);
        Arrays.stream(rooms).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        int rowLen = rooms.length;
        int colLen = rooms[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int row, int col, int step) {
        rooms[row][col] = step;
        for (int i = 0; i < 4; i++) {
            int nRow = row + directs[i][0];
            int nCol = col + directs[i][1];
            if (!isValidGrid(rooms, nRow, nCol, step + 1)) {
                continue;
            }
            dfs(rooms, nRow, nCol, step + 1);
        }
    }

    private boolean isValidGrid(int[][] rooms, int row, int col, int step) {
        return row >= 0 && row < rooms.length && col >= 0 &&
                col < rooms[0].length && rooms[row][col] > 0 && rooms[row][col] > step;
    }
}
