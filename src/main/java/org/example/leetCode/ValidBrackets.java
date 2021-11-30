package org.example.leetCode;

import java.util.Stack;

/**
 * No.20 有效的括号
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // 遍历所有的元素
        for (char c : chars) {
            switch (c) {
            case '(':
                stack.push(')');
                break;
            case '[':
                stack.push(']');
                break;
            case '{':
                stack.push('}');
                break;
            default:
                // 到这里说明是读取到了右括号,则判定栈中的数据是否和c相同,或者栈为空,都返回false
                if (stack.isEmpty() || stack.pop()!=c) {
                    return false;
                }
                break;
            }
        }
        // 如果最后栈为空,则说明是有效的,否则就是无效括号字符
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("括号结果:"+new ValidBrackets().isValid("{{}}()}}"));
    }
}
