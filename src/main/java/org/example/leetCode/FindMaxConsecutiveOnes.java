package org.example.leetCode;

/**
 * No.485 最大连续1的个数
 *
 * 双指针
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int left = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i]==1){
                left++;
                // 当最后一个元素为1时,需要计算count大小
                if(i==nums.length-1){
                    count = Math.max(count,left);
                }
                continue;
            }
            count = Math.max(count,left);
            left=0;
        }
        return count;
    }
}