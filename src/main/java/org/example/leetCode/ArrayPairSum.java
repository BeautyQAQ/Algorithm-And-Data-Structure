package org.example.leetCode;

import java.util.Arrays;

/**
 * No.561 数组拆分 I
 *
 * 双指针
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        // 排序后遍历即可
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                res += nums[i];
            }
        }
        return res;
    }
}