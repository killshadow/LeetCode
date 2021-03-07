package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pond-sizes-lcci/
 *
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 */
public class PondSizes {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}};
        int[] sizeArr = new PondSizes().pondSizes(land);
        System.out.println(Arrays.toString(sizeArr));
    }

    public int[] pondSizes(int[][] land) {
        List<Integer> pondsList = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int size = dfs(land, i, j);
                if (size > 0) {
                    pondsList.add(size);
                }
            }
        }

        int[] sizeArray = pondsList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sizeArray);

        return sizeArray;
    }

    private int dfs(int[][] land, int xIndex, int yIndex) {
        boolean isValidAxis = (xIndex < 0) || (xIndex >= land.length) || (yIndex < 0) ||
                (yIndex >= land[0].length) || (land[xIndex][yIndex] != 0);
        if (isValidAxis) {
            return 0;
        }
        int size = 1;
        land[xIndex][yIndex] = -1;
        size += dfs(land, xIndex - 1, yIndex);
        size += dfs(land, xIndex, yIndex - 1);
        size += dfs(land, xIndex + 1, yIndex);
        size += dfs(land, xIndex, yIndex + 1);
        size += dfs(land, xIndex - 1, yIndex - 1);
        size += dfs(land, xIndex + 1, yIndex - 1);
        size += dfs(land, xIndex + 1, yIndex + 1);
        size += dfs(land, xIndex - 1, yIndex + 1);
        return size;
    }
}
