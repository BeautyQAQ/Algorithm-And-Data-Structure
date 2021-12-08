package org.example.leetcode;

/**
 * No.344 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length<=1) {
            return;
        }
        int left = 0, right = s.length-1;
        char c;
        // 左右位置互换
        while (left<right) {
            c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
