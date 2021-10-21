package org.example.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200.岛屿数量 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 此外，你可以假设该网格的四条边均被水包围。
 * 
 */
public class NumIslands {

    /**
     * 计算岛屿数量
     * @param grid 岛屿模型
     * @param modle 深度优先DFS或者广度优先BFS 
     * @return 岛屿数量
     */
    public static int numIslands(char[][] grid, String modle) {
        // 判断grid是否为空
        if(grid.length==0 || grid == null){
            return 0;
        }
        // 数量记录
        int count = 0;
        // 双for循环遍历grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 从1开始计算
                if ("DFS".equals(modle)) {
                    if (grid[i][j]=='1') {
                        count++;
                        dfs(grid,i,j);
                    }
                }
                if ("BFS".equals(modle)) {
                    if (grid[i][j]=='1') {
                        count++;
                        bfs(grid,i,j);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 深度优先DFS
     * @param grid 参数
     * @param i 位置i
     * @param j 位置j
     */
    public static void dfs(char[][] grid, int i, int j){
        // 判断边界
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        // 当前位置设置为0
        grid[i][j] = '0';
        // 执行当前位置的上下左右四个位置继续递归遍历
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    /**
     * 广度优先BFS
     * @param grid 参数
     * @param i 位置i
     * @param j 位置j
     */
    public static void bfs(char[][] grid, int i, int j){
        // 队列暂存值为 1 的点
        Queue<Integer> queue = new LinkedList<>();
        // 暂存节点位置,用整形存储,减少内存消耗,用[][]数组存储内存消耗翻倍
        queue.add(i*grid[0].length+j);
        // 当前位置设置为0
        grid[i][j] = '0';
        while(!queue.isEmpty()){
            // 取出位置
            Integer location = queue.poll();
            // 分解除数组索引
            int row = location/grid[0].length;
            int col = location%grid[0].length;
            // 上
            if (row-1>=0 && grid[row-1][col] == '1') {
                queue.add((row-1)*grid[0].length+col);
                grid[row-1][col] = '0';
            }
            // 下
            if (row+1<grid.length && grid[row+1][col] == '1') {
                queue.add((row+1)*grid[0].length+col);
                grid[row+1][col] = '0';
            }
            // 左
            if (col-1>=0 && grid[row][col-1] == '1') {
                queue.add(row*grid[0].length+col-1);
                grid[row][col-1] = '0';
            }
            // 右
            if (col+1<grid[0].length&& grid[row][col+1] == '1') {
                queue.add(row*grid[0].length+col+1);
                grid[row][col+1] = '0';
            }
        }
    }

    public static void main(String[] args) {
        char[][] gridDFS = {{'1','0','0','1'},
                            {'0','0','0','0'},
                            {'0','1','0','0'},
                            {'0','0','1','1'}};
        char[][] gridBFS = {{'1','0','0','1'},
                            {'0','0','0','0'},
                            {'0','1','0','0'},
                            {'0','0','1','1'}};
        System.out.println("DFS岛屿数量:"+numIslands(gridDFS, "DFS"));
        System.out.println("BFS岛屿数量:"+numIslands(gridBFS, "BFS"));
    }
}
