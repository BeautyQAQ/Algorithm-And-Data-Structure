package org.example.leetcode;

/**
 * No.28 strStr()
 * 实现 strStr() 函数。 KMP算法
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }  
        int m = haystack.length(),   i=0;
        int n = needle.length(), j=0;
        int[] next = nextBuilder(needle);
        while (i< m  && j<n) {
            if (j<0 || haystack.charAt(i) == needle.charAt(j)) {
                 i ++;j++;
            }else{
                j = next[j];
            }
        }  
        if (j==n) {  
            return i-j;
        }else{
            return -1;
        }
    }
 
    private int[] nextBuilder(String needle){
        int m = needle.length();
        int[] next = new int[m];
        next[0] = -1;  
        int t =  - 1 ,  j=0;
        while (j< m -1) {
            if (t<0 || needle.charAt(t) == needle.charAt(j)) {
                t++;
                j++;
                next[j] = t;
            }else{
                t = next[t];
            }
        }
        return next;
    }
}