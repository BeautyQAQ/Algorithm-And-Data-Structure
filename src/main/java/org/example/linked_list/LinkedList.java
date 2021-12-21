package org.example.linked_list;

/**
 * 链表, 带虚拟头节点
 * 
 */
public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
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
     * 在指定位置插入元素(不常用)
     * @param index 位置
     * @param e 元素
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        // 找到插入节点的前一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 新建一个节点, 插入到index位置
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加元素e
     * @param e 元素
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     * @param e 元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取链表在index位置的元素(不常用)
     * @param index 位置
     * @return 元素
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        // 注意这个遍历和插入的遍历是不同的, 这里的遍历从dummyHead.next(第一个元素)开始,
        // 插入直接从dummyHead(第一个元素的前一个元素)开始
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表第一个元素
     * @return 第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     * @return 最后一个元素
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表在index位置的元素为e
     * @param index 位置
     * @param e 元素
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e(不常用)
     * @param e 元素
     * @return Boolean
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        // 注意这里是需要遍历整个链表(直到cur为null), dummyHead除外
        // 也可以使用for循环, 终止标志为size
        while (cur!=null) {
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 移除链表种index位置的元素并返回(不常用)
     * @param index 位置
     * @return 元素
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        // 要找到待删除元素的前一个节点, 所以从dummyHead开始
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 将待删除节点的前一个节点的next指向待删除节点的.next, 即将删除节点从链表中删除
        Node retNode = prev.next;
        prev.next= retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除链表种第一个元素
     * @return 元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表中最后一个元素
     * @return 元素
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从链表中删除元素e
     * @param e 元素
     */ 
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        // Node cur = dummyHead.next;
        // while (cur!=null) {
        //     res.append(cur).append("->");
        //     cur = cur.next;
        // }
        // 等同于上面的写法
        for(Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur).append("->");
        }

        // 最后一个元素为NULL且后面没有->
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.set(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
        
    }
}
