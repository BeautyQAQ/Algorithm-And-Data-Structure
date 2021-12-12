package org.example.stacks_and_queues.queue;

/**
 * 实现一个有尾指针的LinkedList来实现队列
 * 不直接使用LinkedList来实现队列, 因为LinkedList中没有尾指针, 实现队列性能会不好
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e=e; 
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队, 需要判断尾节点是否为空
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        // 移除头节点
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        // 如果只有一个元素, 被移除后队列为空, 则需要将tail也置空, 所以这里需要判断
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Front ");
        Node cur = head;
        while (cur!=null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        // 最后一个元素为NULL
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
