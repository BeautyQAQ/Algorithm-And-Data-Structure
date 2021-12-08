package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.394 字符串解码 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
 * 
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 */
public class DecodeString {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> resStack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c=='['){
                resStack.push(res);
                numStack.push(num);
                res = new StringBuilder();
                num = 0;
            } else if(c==']'){
                StringBuilder pre = resStack.pop();
                Integer n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    pre.append(res);
                }
                res = pre;
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
