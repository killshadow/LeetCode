package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: killshadow
 * Date: 2021/9/14 0014
 * Description:
 */
public class FindOrder {
    public static void main(String[] args) {
        int[][] req = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int num = 4;
        FindOrder order = new FindOrder();
        System.out.println(Arrays.toString(order.findOrder(num, req)));
    }

    // 用于存储有向图
    List<List<Integer>> edges;
    // 用于存储节点的状态: 0,未访问; 1,访问中; 2,已访问.
    int[] status;
    // 用数组代替栈
    int[] result;
    // 栈顶指针
    int index;
    // 用于标记是否有环, true表示无环, false表示有环
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(i, new ArrayList<>());
        }
        // 有向图是逆序的,要用逆向思维去理解有向图
        for (int[] req : prerequisites) {
            edges.get(req[1]).add(req[0]);
        }
        status = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        // 对所有课程进行深搜,遍历后看是否有环
        for (int i = 0; i < numCourses && valid; i++) {
            // 只有访问没有访问过的节点.(因为该节点可能在其他节点的深搜中被访问过了)
            if (status[i] == 0) {
                dfs(i);
            }
        }
        // 如果有环,则表示课程之间有相互依赖,不可能完成所有课程
        if (!valid) {
            return new int[0];
        }
        return result;
    }

    public void dfs(int course) {
        // 首先标记为该课程正在访问中
        status[course] = 1;
        // 遍历邻接表所有的节点,并对这些没有访问过的节点深搜
        for (int v : edges.get(course)) {
            if (status[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
                // 如果节点正在访问,说明出现了环
            } else if (status[v] == 1) {
                valid = false;
                return;
            }
        }
        // 遍历完成之后,修改当前节点的状态为已访问.
        status[course] = 2;
        // 将该节点加入栈中
        result[index--] = course;
    }
}
