package com.leetcode.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * No.752 打开转盘锁
 * 
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8',
 * '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 锁的初始数字为 '0000'
 * ，一个代表四个拨轮的数字的字符串。 列表 deadends
 * 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 字符串 target
 * 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1
 */
public class OpenLock {

    public static int openLock(String[] deadends, String target) {
        // 保存deadens
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        // 初始字符串 0000
        String startStr = "0000";
        if (deadSet.contains(startStr)) {
            // deadends包含初始字符串,则直接失败
            return -1;
        }
        // 创建队列,逐级遍历
        Queue<String> queue = new LinkedList<>();
        // 创建一个set记录访问过的节点
        Set<String> visited = new HashSet<>();
        queue.offer(startStr);
        visited.add(startStr);
        // 记录树的层数,也是返回结果
        int level = 0;
        while (!queue.isEmpty()) {
            // 每层的子节点
            int size = queue.size();
            // 遍历每层
            while (size-- > 0) {
                // 取出队列中的节点值
                String str = queue.poll();
                // 对每个节点中的4个数字分别加减,类似于八叉树
                for (int i = 0; i < 4; i++) {
                    char ch = str.charAt(i);
                    // 加一操作
                    String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                    // 减一操作
                    String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                    // 找到直接返回
                    if (str.equals(target)) {
                        return level;
                    }
                    // 不能包含死亡数字和已经访问过的数字
                    if (!deadSet.contains(strAdd) && !visited.contains(strAdd)) {
                        queue.offer(strAdd);
                        visited.add(strAdd);
                    }
                    if (!deadSet.contains(strSub) && !visited.contains(strSub)) {
                        queue.offer(strSub);
                        visited.add(strSub);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        // String[] deadends = { "8888" };
        // String target = "0009";
        System.out.println("打开转盘锁:" + openLock(deadends, target));
    }
}
