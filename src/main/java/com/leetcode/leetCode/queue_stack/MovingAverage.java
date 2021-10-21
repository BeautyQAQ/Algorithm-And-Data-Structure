package com.leetcode.leetCode.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode346. 数据流中的移动平均值
 * 题析: 给一个整数流和一个窗口，计算在给定大小的窗口里的数字的平均值。
 * 解法: 队列queue，用一个queue记录进入窗口的整数。
 * 当流进窗口的整数不足时，计算所有窗口内的数字平均值返回，当进入窗口的整数多于窗口大小时，移除最先进入窗口的整数，新的整数进入queue，然后计算窗口内的整数平均值。
 */
public class MovingAverage {
    private double previousSum = 0.0;
    private int maxSize;
    private Queue<Integer> currentWindow;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        currentWindow = new LinkedList<Integer>();
        maxSize = size;
    }
     
    public double next(int val) {
        if(currentWindow.size()==maxSize){
            previousSum -= currentWindow.remove();
        }
        currentWindow.add(val);
        previousSum += val;
        return previousSum/currentWindow.size();
    }
}
 
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */