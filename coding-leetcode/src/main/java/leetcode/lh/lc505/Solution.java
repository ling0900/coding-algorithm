package leetcode.lh.lc505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 对于这道迷宫球的问题，我们可以这样理解：
 * 问题理解： 我们需要找到球从起始位置滚到目的地的最短路径，球会一直沿着一个方向滚动直到碰到墙才停下。
 * 数据结构选择：
 * 可以考虑使用广度优先搜索（Breadth-First Search，BFS）来解决这个问题。因为 BFS 能够保证先搜索到距离起始点较近的节点，从而找到最短路径。
 *
 * 算法步骤：
 * 1、首先创建一个队列来存储待扩展的节点，每个节点包含球的位置和已经走过的步数。
 * 2、将起始位置加入队列，并标记为已访问。
 * 3、从队列中取出一个节点，对其四个方向（上、下、左、右）进行扩展。
 * 4、如果扩展的位置是合法的（在迷宫范围内且为空地且未被访问过），则将其加入队列，并标记为已访问，同时记录走过的步数。
 * 重复步骤 3 和 4，直到队列为空或者找到目的地。
 */
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        // 记录走过的步数（从出发点到当前位置）
        int[][] distance = new int[maze.length][maze[0].length];
        // 这样省时间，如果放到里面填充会超时。
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        distance[start[0]][start[1]] = 0;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 其实是一个长度为2的数组列表
        Deque<int[]> deque = new LinkedList<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                int m = 0;
                while (x >= 0 && x <= maze.length - 1 && y >= 0 && y <= maze[0].length - 1 && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    m++;
                }

                if (distance[cur[0]][cur[1]] + m < distance[x - d[0]][y - d[1]]) {
                    distance[x - d[0]][y - d[1]] = distance[cur[0]][cur[1]] + m;
                    deque.add(new int[] {x - d[0], y - d[1]});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
