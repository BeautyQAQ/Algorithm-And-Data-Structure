package org.example.linked_list;

/**
 * 链表, 不带虚拟头节点
 */
public class LinkedListTest<E> {

    /**
     * 设置一个私有的内部类, 这里也可以是写在外部, 属于设计问题, 自己取舍
     * Node的属性设置成了public, 可以直接从LinkedList类操作, 不需要写getter和setter
     */
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

    private Node head;
    private int size;

    public LinkedListTest(){
        head = null;
        size = 0;
    }
    /**
     * 获取链表的大小
     * @return size
     */
    public int getSize(){
        return size;
    }
    /**
     * 判断链表是否为空
     * @return Boolean
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加元素e
     * @param e 元素
     */
    public void addFirst(E e){
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        // 下面这一句等于上面三句, 在头节点前面新建一个节点, 在让头节点指向它
        head = new Node(e,head);
        size++;
    }

    /**
     * 在指定位置插入元素(不常用)
     * @param index 位置
     * @param e 元素
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            // 找到插入节点的前一个节点
            for (int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            // 新建一个节点, 插入到index位置
            // Node node = new Node(e);
            // node.next = prev.next;
            // prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 在链表末尾添加元素
     * @param e 元素
     */
    public void addLast(E e){
        add(size,e);
    }
}
