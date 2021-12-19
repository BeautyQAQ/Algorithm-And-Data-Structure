package org.example.linked_list;

import org.example.common.ListNode;

/**
 * No.203 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，删除链表中所有满足 Node.val == val 的节点，
 * 并返回新的头节点
 */
public class RemoveElements {
    
    public ListNode removeElements(ListNode head, int val){
        // 先判断头节点是否是需要删除的节点
        while (head!=null && head.val ==val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 如果链表已经被删除完, 则直接返回空
        if (head == null) {
            return null;
        }
        // 删除中间的节点
        ListNode prev = head;
        while (prev.next != null) {
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 虚拟头节点方案
     * @param head 链表头
     * @param val 被删除的值
     * @return 返回表头
     */
    public ListNode removeElementsDummy(ListNode head, int val){
        // 创建虚拟头节点指向当前链表, 这样就可以不对头节点进行特殊处理
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 删除中间的节点
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归删除方案
     * @param head 链表头
     * @param val 被删除的值
     * @return 返回表头
     */
    public ListNode removeElementsRecursion(ListNode head, int val){
        // 递归到底的情况
        if (head == null) {
            return null;
        }
        // 更小的递归问题
        head.next = removeElementsRecursion(head.next, val);
        return head.val==val ? head.next : head;
    }
    public static void main(String[] args) {
        int[] numbs = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(numbs);
        System.out.println(head);
        RemoveElements removeElements = new RemoveElements();
        ListNode result = removeElements.removeElements(head, 6);
        System.out.println(result);

        System.out.println("---------------分割线--------------");
        head = new ListNode(numbs);
        result = removeElements.removeElementsRecursion(head, 6);
        System.out.println(result);
    }
}
