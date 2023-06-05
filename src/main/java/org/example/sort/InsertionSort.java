package org.example.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度为 O(n^2)，稳定排序算法。
 */
public class InsertionSort {

    public static void main(String[] args) {
            int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
            // 只需要修改成对应的方法名就可以了
            insertionSort(array);
            System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    
}
