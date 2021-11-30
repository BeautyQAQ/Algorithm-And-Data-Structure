package org.example.leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

    /**
     * 打开转盘锁-单向BFS
     * @param deadends 禁止列表
     * @param target 目标值
     * @return 层级
     */
    public int openLock(String[] deadends, String target) {
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

    /**
     * 打开转盘锁-双向BFS
     * @param deadends 禁止列表
     * @param target 目标值
     * @param modle 模式-双向BFS
     * @return 层级
     */
    public int openLock(String[] deadends, String target, String modle) {
        // 定义初始字符 0000
        String start = "0000";
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        // deadens包含目标值和初始值,直接返回-1
        if(set.contains(target)||set.contains(start)){
            return -1;
        }
        // 对比第一个值是否已经拿到目标对象
        if (start.equals(target)) {
            return 0;
        }
        return bfs(set, target, start);
    }


    private int bfs(Set<String> set, String target, String start) {
        // 定义两个队列,分别记录从正向和反向搜索的字符
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        // 定义两个map, 标记每个字符是由当前字符转换多少次得来
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        d1.add(start);
        map1.put(start, 0);
        d2.add(target);
        map2.put(target, 0);

        // 两个队列都不为空时,才往下进行搜索
        while (!d1.isEmpty()&&!d2.isEmpty()) {
            int t = -1;
            if(d1.size()<=d2.size()){
                t=update(d1,map1,map2,set);
            }else{
                t=update(d2,map2,map1,set);
            }
            if (t!=-1) {
                return t;
            }
        }
        return -1;
    }

    /**
     * 从队列中取出值进行变换
     * @param deque 队列
     * @param cur 当前方向的map
     * @param orther 另一方向的map
     */
    private int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> orther,Set<String> set) {
        String poll = deque.pollFirst();
        for (int i = 0; i < poll.length(); i++) {
            // 循环做加一或者减一操作单
            char ch = poll.charAt(i);
            String sub = "";
            for (int j = -1; j <= 1; j++) {
                // 等于0时跳过
                if(j==0){
                    continue;
                }
                if(j==1){
                    // 加1操作
                    sub = poll.substring(0, i)+(char)(ch=='9'?'0':ch+1)+poll.substring(i+1);
                }
                if(j==-1){
                    // 减1操作
                    sub = poll.substring(0, i)+(char)(ch=='0'?'9':ch-1)+poll.substring(i+1);
                }
                if (set.contains(sub)) {
                    continue;
                }
                if (cur.containsKey(sub)) {
                    continue;
                }

                // 如果在另一个方向找到,说明找到了目标值,返回层数
                if (orther.containsKey(sub)) {
                    return cur.get(poll)+1+orther.get(sub);
                }else{
                    deque.add(sub);
                    cur.put(sub, cur.get(poll)+1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // String[] deadends = {"0201","0101","0102","1212","2002"};
        // String target = "0202";

        // String[] deadends = { "8888" };
        // String target = "0009";

        // String[] deadends = { "0000" };
        // String target = "8888";

        String[] deadends = { "0201","0101","0102","1212","2002" };
        String target = "0000";
        OpenLock openLock = new OpenLock();
        System.out.println("打开转盘锁:" + openLock.openLock(deadends, target));
        System.out.println("打开转盘锁双向BFS:" + openLock.openLock(deadends, target, "双向BFS"));
    }
}
