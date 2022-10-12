package org.example.linked_list;

import org.example.common.ListNode;
import org.example.stacks_and_queues.queue.ArrayQueue;
import org.example.stacks_and_queues.queue.Queue;
import org.example.stacks_and_queues.stack.ArrayStack;

/**
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 如输入{1,2,3}的链表
 * 返回一个数组为[3,2,1]
 * 0 <= 链表长度 <= 10000
 * 
 * 输入：{1,2,3}
 * 返回值：[3,2,1]
 * 
 * 输入：{67,0,24,58}
 * 返回值：[58,24,0,67]
 */
public class PrintListFromTailToHead {

    /**
     * 1.使用栈的方式
     */
    public Queue<Integer> printListFromTailToHead1(ListNode listNode){
        Queue<Integer> res = new ArrayQueue<>();
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            res.enqueue(stack.pop());
        }
        return res;
    }

    /**
     * 2.使用递归方式：当链表过长时，会导致栈溢出
     */
    public Queue<Integer> printListFromTailToHead2(ListNode listNode){
        Queue<Integer> res = new ArrayQueue<>();
        print(res, listNode);
        return res;
    }

    private void print(Queue<Integer> res, ListNode listNode){
        // 递归结束点
        if (listNode == null) {
            return;
        }
        print(res, listNode.next);
        res.enqueue(listNode.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);

        PrintListFromTailToHead test = new PrintListFromTailToHead();
        Queue<Integer> printListFromTailToHead1 = test.printListFromTailToHead1(listNode);
        System.out.println(printListFromTailToHead1);
        Queue<Integer> printListFromTailToHead2 = test.printListFromTailToHead2(listNode);
        System.out.println(printListFromTailToHead2);
    }
}
