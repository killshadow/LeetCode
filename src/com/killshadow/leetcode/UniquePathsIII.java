package com.killshadow.leetcode;

public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new UniquePathsIII().uniquePathsIII(input));
    }

    public int uniquePathsIII(int[][] grid) {
        int pathNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    System.out.println("row: " + i + "; col: " + j);
                    pathNum = dfs(i, j, grid);
                }
            }
        }
        return pathNum;
    }

    public int dfs(int row, int col, int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        boolean isValidPosition = (row < rowLen) && (row >= 0) &&
                (col < colLen) && (col >= 0) && (grid[row][col] != -1);
        if (!isValidPosition) {
            return 0;
        }

        // 检测到终点, 看是否已经走完全部点
        if (grid[row][col] == 1) {
            boolean isAllFlag = true;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == 0) {
                        isAllFlag = false;
                    }
                }
            }
            return isAllFlag ? 1 : 0;
        }

        boolean isPassedPos = false;
        if (grid[row][col] == 0) {
            grid[row][col] = -1;
            isPassedPos = true;
        }

        boolean isEndPos = false;
        if (grid[row][col] == 2) {
            grid[row][col] = -1;
            isEndPos = true;
        }

        int res = dfs(row - 1, col, grid) + dfs(row, col - 1, grid) +
                dfs(row + 1, col, grid) + dfs(row, col + 1, grid);

        if (isPassedPos) {
            grid[row][col] = 0;
        }

        if (isEndPos) {
            grid[row][col] = 2;
        }

        return res;
    }
}
