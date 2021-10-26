package org.example.leetCode;

import java.util.Stack;

/**
 * No.232 用栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * 将栈1的数据移动到栈2,保证队列先入先出的特性
     * @param stack1 栈1-源
     * @param stack2 栈2-目标
     */
    private void stack1ToStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
