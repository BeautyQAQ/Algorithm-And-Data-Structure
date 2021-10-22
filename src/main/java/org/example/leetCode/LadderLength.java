package org.example.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 127. 单词接龙
 * 
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 序列中第一个单词是
 * beginWord。 序列中最后一个单词是 endWord 。 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList， 找到从 beginWord 到 endWord 的最短转换序列
 * 中的单词数目。如果不存在这样的转换序列，返回 0。
 */
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 定义set保存wordList
        Set<String> set = new HashSet<>(wordList);
        // wordList中不存在目标单词,返回0
        if (!set.contains(endWord)) {
            return 0;
        }
        return bfs(beginWord,endWord,set) == -1 ? 0 : bfs(beginWord,endWord,set)+1;
    }

    public static int bfs(String beginWord, String endWord,Set<String> set) {
        // d1表示正向搜索
        Deque<String> d1 = new ArrayDeque<>();
        // d2表示反向搜索
        Deque<String> d2 = new ArrayDeque<>();
        // map1和map2记录每个单词分别是由正向和反向多少次转换而来,比如map1={"abc":1}代表abc由beginEnd转换1次而来
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        d1.add(beginWord);
        map1.put(beginWord, 0);
        d2.add(endWord);
        map2.put(endWord, 0);
        // 只有两个队列都不为空才要继续搜索,如果有一个为空,说明由其中一个方向搜索到底也没有结果,则停止循环
        while (!d1.isEmpty()&&!d2.isEmpty()) {
            int t = -1;
            // 保证搜索数量的平均,优先拓展队列内单词少的队列, 注意要由起始map先执行,否则当wordList只有一个单词并且等于endWord时会出现死循环
            if (d1.size()<=d2.size()) {
                t = update(d1,map1,map2,set);
            }else{
                t = update(d2,map2,map1,set);
            }
            if (t!=-1) {
                return t;
            }
        }
        return -1;
    }

    /**
     * 从队列中取出一个单词进行变换
     * @param deque 单词队列
     * @param cur 当前方向记录
     * @param orther 另一方向记录
     * @return 变换次数
     */
    private static int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> orther,Set<String> set) {
        // 从队列中取出一个单词
        String poll = deque.pollFirst();
        // 循环替换这个单词
        for (int i = 0; i < poll.length(); i++) {
            for (int j = 0; j < 26; j++) {
                // 替换后的字符(从a开始轮询到z)
                String sub = poll.substring(0, i)+(char)('a'+j)+poll.substring(i+1);
                // 替换后的字符串必须存在wordList才继续进行判定,否则直接继续替换
                if (set.contains(sub)) {
                    // 替换后的字符串必在当前方向已经记录过,则直接跳过
                    if (cur.containsKey(sub)) {
                        continue;
                    }
                    // 替换后的值在另一方向记录过,则说明找到目标字符串
                    if(orther.containsKey(sub)){
                        return cur.get(poll)+1+orther.get(sub);
                    }else{
                        // 否则加入队列
                        deque.add(sub);
                        cur.put(sub, cur.get(poll)+1);
                    }
                }   
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("cog");
        int ladderLength = ladderLength("hog", "cog", list);
        System.out.println(ladderLength);
    }
}
