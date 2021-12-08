package org.example.leetcode;

/**
 * No.167 两数之和 II - 输入有序数组
 *
 * 双指针
 * 给定一个已按照 非递减顺序排列 的整数数组 numbers，
 * 请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{-1,-1};
        int left = 0, right = numbers.length-1;
        for(int i=0;i<numbers.length-1;i++){
            // 循环结束,没有结果
            if(left>right){
                return res;
            }
            if(numbers[left]+numbers[right]<target){
                // 小于目标值,左指针右移,变大
                left++;
            }else if(numbers[left]+numbers[right]>target){
                // 大于目标值,右指针左移,变小
                right--;
            }
            else{
                // 返回左右指针加一的结果
                res[0] = left+1;
                res[1] = right+1;
            }
        }
        return res;
    }
}