package org.example.map;

import java.util.ArrayList;

import org.example.set.FileOperation;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * 树节点
     */
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private int size;
    private Node root;

    public BSTMap(){
        root = null;
        size = 0;
    }

    /**
     * 向二分搜索树中添加元素key, value
     * @param key 元素键
     * @param value 元素值
     */
    @Override
    public void add(K key, V value){
        root = add(root, key, value);
    }

    /**
     * 递归函数, 向以node为根节点的树插入元素key, value, 返回插入节点后的二分搜索树的根
     * @param node 根节点
     * @param key 元素键
     * @param value 元素值
     * @return 根节点
     */
    private Node add(Node node, K key, V value){
        // 递归终止条件, 到达node为空的节点时, 直接返回新的节点
        if (node == null) {
            size ++ ;
            return new Node(key, value);
        }
        // 递归过程, 往树的左右两边递归
        if (key.compareTo(node.key)<0) {
            node.left = add(node.left, key, value);
        }
        if (key.compareTo(node.key)>0) {
            node.right = add(node.right, key, value);
        }
        return node;
    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     * @param node 查询的根节点
     * @param key key
     * @return key所在节点
     */
    private Node getNode(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key)<0) {
            return getNode(node.left, key);
        }else if(key.compareTo(node.key)>0){
            return getNode(node.right, key);
        }else{
            return node;
        }
    }

    /**
     * 查询二分搜索树中是否包含元素e
     * @param e 元素
     * @return Boolean
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 递归函数, 寻找以node为根节点的的二分搜索树的最小元素所在的节点
     * @param node 根节点node
     * @return 最小元素所在的节点
     */
    private Node minimum(Node node){
        // 只需要关注左子树
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 递归删除最小值
     * @param node 最小值所在节点
     */
    private Node removeMin(Node node) {
        // 递归终止
        if (node.left == null) {
            Node right = node.right;
            // 将node移除
            node.right = null;
            size--;
            return right;
        }
        // 用左子树去接
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 二分搜索树删除元素为e的节点
     * @param key 元素e
     */
    @Override
    public V remove(K key){
        BSTMap<K, V>.Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 递归删除以node为根节点的元素
     * @param node 根节点
     * @param key 元素
     * @return 删除节点后的二分搜索树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key)<0) {
            node.left = remove(node.left, key);
            return node;
        } else if(key.compareTo(node.key)>0){
            node.right = remove(node.right, key);
            return node;
        } else {
            // 找到了待删除的节点
            if (node.left == null) {
                // 左子树为空
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.left == null) {
                // 右子树为空
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            /*待删除节点左右子树均不为空
              找到比待删除节点大的最小节点(后继), 即待删除节点右子树的最小节点
              用这个节点顶替待删除的位置 */
            Node successor = minimum(node.right);
            // 注意removeMin已经对size--
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        BSTMap<K, V>.Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        BSTMap<K, V>.Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }
    
    public static void main(String[] args){

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
