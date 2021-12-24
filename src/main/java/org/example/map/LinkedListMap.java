package org.example.map;

public class LinkedListMap<K, V> implements Map<K, V> {

    /**
     * 设置一个私有的内部类, 这里也可以是写在外部, 属于设计问题, 自己取舍
     * Node的属性设置成了public, 可以直接从LinkedList类操作, 不需要写getter和setter
     */
    private class Node{
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next){
            this.key=key;
            this.value = value; 
            this.next = next;
        }
        public Node(K key, V value){
            this(key, value, null);
        }
        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在头结点添加
     * @param key key
     * @param value value
     */
    @Override
    public void add(K key, V value) {
        LinkedListMap<K, V>.Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }else{
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next!=null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next!=null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    /**
     * 获取当前key所在的节点
     * @param key key
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur.next!=null) {
            if (cur.value.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V newValue) {
        LinkedListMap<K, V>.Node node = getNode(key);        
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }
    
}
