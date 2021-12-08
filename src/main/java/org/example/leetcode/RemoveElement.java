package org.example.leetcode;

/**
 * No.485 移除元素
 *
 * 双指针
 * 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int i=0; i<nums.length; ++i){
            // 等于目标值时,不进行元素复制
            if(nums[i]==val){
                continue;
            }
            nums[slow] =nums[i];
            slow++;
        }
        return slow;
    }
}
