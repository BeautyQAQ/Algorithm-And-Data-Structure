package org.example.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * No.279 完全平方数 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16,...）
 * 使得它们的和等于n。你需要让组成和的完全平方数的个数最少。 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 完全平方数
 * 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class NumSquares {
    /**
     * BFS方法计算完全平方数
     * 
     * @param n 目标值
     * @return int结果
     */
    public int numSquaresBFS(int n) {
        // 记录BFS遍历的队列
        Queue<Integer> queue = new LinkedList<>();
        // 记录访问过的节点
        Set<Integer> visited = new HashSet<>();
        // 从0开始
        queue.offer(0);
        visited.add(0);
        // 标记层级
        int level = 0;
        while (!queue.isEmpty()) {
            // 每层节点数
            int size = queue.size();
            level++;
            // 遍历这层的所有节点
            for (int i = 0; i < size; i++) {
                // 节点值
                int value = queue.poll();
                // 访问当前层节点的所有子节点
                for (int j = 0; j < n; j++) {
                    // 子节点的值=父节点+完全平方数,这么做保证子节点一定是完全平方数的和
                    int nodeValue = value + j*j;
                    if (n==nodeValue) {
                        return level;
                    }
                    // 如果内层循环大于n,则终止内层循环
                    if (nodeValue>n) {
                        break;
                    }
                    if(!visited.contains(nodeValue)){
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println("numSquaresBFS:"+new NumSquares().numSquaresBFS(11));
    }
}
