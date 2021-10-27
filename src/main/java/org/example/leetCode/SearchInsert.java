package org.example.leetCode;

/**
 * No.35 搜索插入位置
 * 
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target) {
                flag = false;
                return i;
            }
        }
        if (flag) {
            for (int i = 0; i < nums.length; i++) {
                if (target<nums[i]) {
                    return i;
                }
            }
        }
        return nums.length;
    }

    /**
     * 直接判断目标值是否小于等于num[i]
     * @param nums 升序数组
     * @param target 目标
     * @return 下标
     */
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分法
     * @param nums 升序数组
     * @param target 目标
     * @return 下标
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if (nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if (nums[mid]>target) {
                right = mid -1;
            }
        }
        return left;
    }
}
