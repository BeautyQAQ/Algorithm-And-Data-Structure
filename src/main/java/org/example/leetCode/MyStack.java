package org.example.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.225 用队列实现栈
 */
public class MyStack {

    private Queue<Integer> linkedList1;
    private Queue<Integer> linkedList2;

    public MyStack() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
    }
    
    // 保证每次入队的数据都在队列的头,这样就能实现栈--后入先出的特性
    public void push(int x) {
        linkedList2.offer(x);
        while(!linkedList1.isEmpty()){
            linkedList2.offer(linkedList1.poll());
        }
        // Q1和Q2交完位置
        Queue<Integer> temp = linkedList1;
        linkedList1 = linkedList2;
        linkedList2 = temp;
    }
    
    public int pop() {
        return linkedList1.poll();
    }
    
    public int top() {
        return linkedList1.peek();
    }
    
    public boolean empty() {
        return linkedList1.isEmpty();
    }
}
