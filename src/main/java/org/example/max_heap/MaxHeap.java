package org.example.max_heap;

import java.util.Random;

import org.example.arrays.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    /**
     * heapify操作, 将一个数组转换成堆, 性能比一个一个添加元素要好:
     * heapify: O(n)
     * 逐个添加元素: O(nlogn)
     * @param arr 数组
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length -1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 获取完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
     * @param index 查找索引
     * @return 父亲节点索引
     */
    private int parent(int index){
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does't have parent.");
        }
        return (index-1) / 2;
    }

    /**
     * 获取完全二叉树的数组表示中, 一个索引所表示的元素的左孩子的索引
     * @param index 查找索引
     * @return 左孩子索引
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 获取完全二叉树的数组表示中, 一个索引所表示的元素的右孩子的索引
     * @param index 查找索引
     * @return 右孩子索引
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e 元素
     */
    public void add(E e){
        data.addLast(e);
        // 从刚刚添加的最后一位开始交换位置
        siftUp(data.getSize()-1);
    }

    /**
     * 从k开始, 自底向上交换元素
     * @param k
     */
    private void siftUp(int k) {
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看堆中最大元素
     * @return 最大值
     */
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return 最大值
     */
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 从k开始自顶向下交换元素位置
     * @param k 起始位置
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))>0) {
                // data[j] 是 leftChild 和 rightChild 中的最大值
                j++;
            }
            if (data.get(k).compareTo(data.get(j))>=0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素, 并且替换成元素e
     * @param e 元素
     * @return 最大值
     */
    public E replace(E e){
        E ret = findMax();
        // 将最大值(索引0)直接替换成元素e
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
