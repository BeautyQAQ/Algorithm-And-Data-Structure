package org.example.common;

/**
 * 单链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 参数为数组的构造函数
     * @param arr 数组
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length ==0) {
            throw new IllegalArgumentException("arr can not be empty!");
        }
        // 递归终止条件
        this.val = arr[0];
        ListNode cur = this;
        // 循环中递归调用
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
