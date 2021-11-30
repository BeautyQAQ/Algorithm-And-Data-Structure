package org.example.leetCode;

/**
 * No.151 翻转字符串里的单词
 */
public class ReverseWords {
    /**
     * 方法一;思路：数组的翻转
     * 
     * @param s 参数字符串
     * @return 翻转单词
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int length = split.length;
        // 从后往前遍历
        while (length > 0) {
            --length;
            if (split[length].length() != 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(split[length]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * No.557 反转字符串中的单词 III
     *
     * @param s 单词字符串
     * @return 反转
     */
    public String reverseWords3(String s) {
        String[] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String res = reverseStr(str[i]);
            if (i == str.length - 1) {
                stringBuilder.append(res);
            } else {
                stringBuilder.append(res).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * // 反转单字符串
     *
     * @param s 字符串
     * @return 反转
     */
    private String reverseStr(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            right--;
            left++;
        }
        return String.valueOf(chars);
    }
}
