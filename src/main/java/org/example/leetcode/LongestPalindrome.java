package org.example.leetcode;

/**
 * No.5 最长回文子串
 *
 */
public class LongestPalindrome {
    /**
     * 暴力求解
     * @param s 参数字符串
     * @return 回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length()==0) {
            return "";
        }
        // 第一层遍历表示子串长度
        for (int i = s.length(); i > 0; --i) {
            for (int j = 0; j <= s.length()-i; j++) {
                // 判断回文字符串
                if (isPalindrome(s,j,j+i-1)){
                    // 截取字符串并返回
                    return s.substring(j,j+i);
                }
            }
        }
        return "";
    }

    /**
     * 判断字符串是否回文
     * @param s 参数字符串
     * @param left 左起点
     * @param right 右起点
     * @return boolean
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
