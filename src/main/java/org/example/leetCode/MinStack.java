package org.example.leetCode;

/**
 * No.155 最小栈
 */
public class MinStack {

    // 链表头
    private ListNode head;

    public MinStack() {

    }

    /**
     * 压栈,需要判空
     * @param val 入参
     */
    public void push(int val) {
        if (empty()) {
            head = new ListNode(val, val, null);
        }else{
            head = new ListNode(val, Math.min(val, head.min), head);
        }
    }
    
    private boolean empty() {
        return head == null;
    }

    /**
     * 出栈,删除表头
     */
    public void pop() {
        if(empty()){
            throw new IllegalStateException("栈为空");
        }else{
            head = head.next;
        }
    }

    /**
     * 栈顶值就是表头值
     * @return 返回栈顶的值
     */
    public int top() {
        if(empty()){
            throw new IllegalStateException("栈为空");
        }else{
            return head.val;
        }
    }
    
    /**
     * 栈中最小值
     * @return 返回栈顶的最值
     */
    public int getMin() {
        if(empty()){
            throw new IllegalStateException("栈为空");
        }else{
            return head.min;
        }
    }

    /**
     * 链表内部类
     */
    class ListNode{
        int val;
        int min;
        ListNode next;
        public ListNode(int val, int min, ListNode next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
