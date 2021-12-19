package org.example.linked_list;

public class Sum {
    /**
     * 数组元素相加
     * @param arr 数组
     * @return int
     */
    public static int sum(int[] arr){
        return sum(arr, 0);
    }
    
    /**
     * 递归实现数组从[l, n)位置的元素相加
     * @param arr 数组
     * @param l 起始位置
     * @return int
     */
    public static int sum(int[] arr, int l){
        if (l>arr.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        // 求解最基本问题
        if (l== arr.length) {
            return 0;
        }
        // 把原问题转换成更小的问题
        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
