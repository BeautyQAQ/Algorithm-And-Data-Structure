package org.example.segment_tree;

/**
 * No.303 区域和检索 - 数组不可变
 * 
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 */
public class NumArray {

    /**
     * SegmentTree解法
     */
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b)->a+b);
        }
    }
    
    public int sumRange(int left, int right) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(left, right);
    }

    //--------------------------------分割线-------------------------------
    /* sum[i]存储前i个元素和, sum[0] = 0
       即sum[i]存储nums[0...i-1]的和
       sum(i, j) = sum[j + 1] - sum[i] */
    private int[] sum;

    public void NumArray2(int[] nums){
        sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i = 1; i<sum.length; i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange1(int left, int right){
        return sum[right+1]-sum[left];
    }
}
