package org.example.leetCode;

/**
 * No.283 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length<1){
            return;
        }
        int left=0, right=0;
        while (right<nums.length){
            if (nums[right]==0){
                right++;
            }else{
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        for (; left < nums.length; left++) {
            nums[left] = 0;
        }
    }
}
