package org.example.leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
/**
 * 面试遇到的算法题
 * 输入一个字符串，求出现最多的字符次数和最少的次数
 * 统计字符串中出现最多或最少的次数
 */
public class CountString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new CountString().countStringMoreAndLess("eabcdssasbccdddddsesssaaa");
    }

    /**
     * 统计字符串出现最多和最少的个数;
     * @return
     */
    public void countStringMoreAndLess(String str){
        Map<String,Integer> map = new TreeMap<String, Integer>();
        int count = 0;
        if(str!=null && !"".equals(str.trim())){
            // 根据字符串长度循环
            for(int i = 0;i<str.length();i++){
                count = 0;
                String tempString = str.substring(i, i+1);
                for(int x = 0;x<=i;x++){
                    if(tempString.equals(str.substring(x, x+1))){
                        count++;
                    }
                }
                map.put(tempString, count);
            }
        }

        int max = Collections.max(map.values());
        int min = Collections.min(map.values());
        System.out.println("字符串中出现最多的次数是:"+max+"次,出现最少的次数是:"+min+"次");
    }
}
