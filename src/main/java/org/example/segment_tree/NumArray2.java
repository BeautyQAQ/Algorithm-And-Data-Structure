package org.example.segment_tree;

/**
 * No.307 区域和检索 - 数组可修改
 * 
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * 
 */
public class NumArray2 {

    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length!=0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a,b)->a+b);
        }
    }
    
    public void update(int index, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Error");
        }
        segmentTree.set(index, val);
    }
    
    public int sumRange(int left, int right) {
        if(segmentTree == null)
            throw new IllegalArgumentException("Error");
        return segmentTree.query(left, right);
    }


    //--------------------------------分割线-------------------------------
    private int[] data;
    private int[] sum;
    public void NumArray(int[] nums){
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public void update2(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + data[i-1];
        }
    }

    public int sumRange2(int left, int right) {
        return sum[right+1] - sum[left];
    }

}
