package org.example.max_heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.example.stacks_and_queues.queue.PriorityQueue;

/**
 * No.347 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {

    /**
     * LeetCode返回值
     * @param nums 数组nums
     * @param k 返回值长度
     * @return 数组
     */
    public int[] topKFrequentLeetCode(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            }else if (map.get(key)>map.get(queue.peek())){
                // map的值大于堆中的最小值, 则将优先队列的最小值移除
                queue.remove();
                queue.add(key);
            }
        }
        int size = queue.size();
        int[] res = new int[queue.size()];
        for (int i = 0; i < size; i++) {
            res[i] = queue.remove();
        }
        return res;
    }
    
    private class Freq implements Comparable<Freq>{
        int e, freq;
        
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            // 我们实现的是最大堆, 所有优先级最高的, 存放频次最低的元素
            if (this.freq < another.freq) {
                return 1;
            }else if (this.freq > another.freq) {
                return -1;
            }else {
                return 0;
            }
        }
    }
    
    /**
     * 自己实现的优先队列
     * @param nums 数组nums
     * @param k 返回值长度
     * @return List
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(key, map.get(key)));
            }else if (map.get(key)>queue.getFront().freq){
                // map的值大于堆中的最小值, 则将优先队列的最小值移除
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.dequeue().e);
        }
        return res;
    }


    private class FreqJava implements Comparable<FreqJava>{
        int e, freq;
        
        public FreqJava(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqJava another){
            // Java的优先队列是最小堆, 所有优先级最高的, 存放频次最低的元素
            if (this.freq < another.freq) {
                return -1;
            }else if (this.freq > another.freq) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    /**
     * Java的优先队列
     * 需要注意: Java的优先队列是最小堆
     * @param nums 数组nums
     * @param k 返回值长度
     * @return List
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        java.util.PriorityQueue<FreqJava> queue = new java.util.PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new FreqJava(key, map.get(key)));
            }else if (map.get(key)>queue.peek().freq){
                // map的值大于堆中的最小值, 则将优先队列的最小值移除
                queue.remove();
                queue.add(new FreqJava(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove().e);
        }
        return res;
    }

    /**
     * Java的优先队列
     * lamba表达式
     * @param nums 数组nums
     * @param k 返回值长度
     * @return List
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            }else if (map.get(key)>map.get(queue.peek())){
                // map的值大于堆中的最小值, 则将优先队列的最小值移除
                queue.remove();
                queue.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        printList(topKFrequent.topKFrequent(nums, k));
        printList(topKFrequent.topKFrequent1(nums, k));
        printList(topKFrequent.topKFrequent2(nums, k));
    }
}
