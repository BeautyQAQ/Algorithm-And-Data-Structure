package org.example.leetcode;

/**
 * No.153 寻找旋转排序数组中的最小值
 * 
 * 二分查找
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right-left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
