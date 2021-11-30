package org.example.leetCode;

/**
 * No.1991 寻找数组的中心索引
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 先求得数组中所有元素之和sum； 
     * 遍历数组，取当前下标左边的元素之和left_sum，同时sum减去已遍历元素，比较二者是否相等，相等则返回当前下标；
     * 遍历结束，代表没有中心索引，返回-1；
     * 
     * @param nums 数组
     * @return int
     */
    public int pivotIndex1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum-=nums[i];
            if (left==sum) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int pivotIndex1 = pivotIndex.pivotIndex(new int[] { 2, 1, -1 });
        int pivotIndex2 = pivotIndex.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 });
        int pivotIndex3 = pivotIndex.pivotIndex1(new int[] { -1, -1, -1, -1, -1, -1 });
        System.out.println("pivotIndex1=" + pivotIndex1);
        System.out.println("pivotIndex2=" + pivotIndex2);
        System.out.println("pivotIndex3=" + pivotIndex3);
    }
}
