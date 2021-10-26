package org.example.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.542 01矩阵 
 * 
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * BFS 广度优先搜索
 */
public class UpdateMatrix {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            for (int k = 0; k < 4; k++) {
                int x = i+dirs[k][0], y = j+dirs[k][1];
                if(x>=0&&x<m&&y>=0&&y<n&&!visited[x][y]){
                    res[x][y] = res[i][j]+1;
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }
}
