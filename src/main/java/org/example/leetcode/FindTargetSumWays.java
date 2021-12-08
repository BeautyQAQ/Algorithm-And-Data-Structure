package org.example.leetcode;

/**
 * No.494 目标和
 * 
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class FindTargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int target, int cur) {
        if(index==nums.length){
            if(cur==target){
                count++;
            }
            return;
        }
        dfs(nums, index+1, target, cur+nums[index]);
        dfs(nums, index+1, target, cur-nums[index]);
    }
}
