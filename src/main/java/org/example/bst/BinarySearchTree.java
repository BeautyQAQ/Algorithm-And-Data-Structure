package org.example.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.example.stacks_and_queues.stack.ArrayStack;

/**
 * 二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 树节点
     */
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private int size;
    private Node root;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素e
     * @param e 元素e
     */
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 递归函数, 向以node为根节点的树插入元素e, 返回插入节点后的二分搜索树的根
     * @param node 根节点
     * @param e 元素e
     * @return 根节点
     */
    public Node add(Node node, E e){
        // 递归终止条件, 到达node为空的节点时, 直接返回新的节点
        if (node == null) {
            size ++ ;
            return new Node(e);
        }
        // 递归过程, 往树的左右两边递归
        if (e.compareTo(node.e)<0) {
            node.left = add(node.left, e);
        }
        if (e.compareTo(node.e)>0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查询二分搜索树中是否包含元素e
     * @param e 元素
     * @return Boolean
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归函数,查询二分搜索树中是否包含元素e
     * @param node 节点
     * @param e 元素
     * @return Boolean
     */
    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e)<0) {
            return contains(node.left, e);
        }else if (e.compareTo(node.e)>0) {
            return contains(node.right, e);
        }else{
            return true;
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 递归算法, 前序遍历以node为根节点的二分搜索树
     * @param node 根节点
     */
    private void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树前序遍历的非递归实现
     */
    public void preOrderNR(){
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 先访问当前节点
            Node cur = stack.pop();
            System.out.println(cur.e);
            stack.push(cur.right);
            stack.push(cur.left);
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 递归算法, 中序遍历以node为根节点的二分搜索树
     * @param node 根节点
     */
    private void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 递归算法, 后序遍历以node为根节点的二分搜索树
     * @param node 根节点
     */
    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        System.out.println(node.e);
        postOrder(node.right);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return 最小元素
     */
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("Binary Search Tree is empty!");
        }
        return minimum(root).e;
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
     * 寻找二分搜索树的最大元素
     * @return 最大元素
     */
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("Binary Search Tree is empty!");
        }
        return maximum(root).e;
    }

    /**
     * 递归函数, 寻找以node为根节点的的二分搜索树的最大元素所在的节点
     * @param node 根节点node
     * @return 最大元素所在的节点
     */
    private Node maximum(Node node){
        // 只需要关注右子树
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点
     * @return 返回最小值
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
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
     * 从二分搜索树中删除最大值所在节点
     * @return 返回最大值
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 递归删除最大值
     * @param node 最大值所在节点
     */
    private Node removeMax(Node node) {
        // 递归终止
        if (node.right == null) {
            Node left = node.left;
            // 将node移除
            node.left = null;
            size--;
            return left;
        }
        // 用右子树去接
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 二分搜索树删除元素为e的节点
     * @param e 元素e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 递归删除以node为根节点的元素e
     * @param node 根节点
     * @param e 元素e
     * @return 删除节点后的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e)>0){
            node.right = remove(node.right, e);
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
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node 根节点
     * @param depth 深度
     * @param res 字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * 打印深度
     * @param depth 深度
     * @return 字符串
     */
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        BST<Integer> b = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            int nextInt = random.nextInt(10000);
            bst.add(nextInt);
            b.add(nextInt);
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while(!bst.isEmpty()){
            list.add(bst.removeMin());
            list1.add(b.removeMin());
        }
        System.out.println(list);
        System.out.println(list1);
        // for(int i = 1 ; i < list.size() ; i ++)
        //     if(list.get(i - 1) > list.get(i))
        //         throw new IllegalArgumentException("Error!");
        // System.out.println("removeMin test completed.");

        // // test removeMax
        // for(int i = 0 ; i < n ; i ++)
        //     bst.add(random.nextInt(10000));

        // list = new ArrayList<>();
        // while(!bst.isEmpty())
        //     list.add(bst.removeMax());

        // // System.out.println(list);
        // for(int i = 1 ; i < list.size() ; i ++)
        //     if(list.get(i - 1) < list.get(i))
        //         throw new IllegalArgumentException("Error!");
        // System.out.println("removeMax test completed.");
    }
}
