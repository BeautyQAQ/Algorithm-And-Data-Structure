package org.example.leetCode;

/**
 * No.151 翻转字符串里的单词
 */
public class ReverseWords {
    /**
     * 方法一;思路：数组的翻转
     * @param s 参数字符串
     * @return 翻转单词
     */
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int length = split.length;
        // 从后往前遍历
        while (length>0){
            --length;
            if (split[length].length()!=0){
                if (stringBuilder.length()>0){
                    stringBuilder.append(" ");
                }
                stringBuilder.append(split[length]);
            }
        }
        return stringBuilder.toString();
    }
    
}
