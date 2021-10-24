package org.example.leetCode;

import java.util.Stack;

/**
 * No.739 每日温度
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&& temperatures[i]>temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {73,74,75,71,69,72,76,73};
        int[] dailyTemperatures = dailyTemperatures(a);
        for (int i : dailyTemperatures) {
            System.out.print(i+",");
        }
    }
}
