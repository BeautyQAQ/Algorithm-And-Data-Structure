package org.example.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度为 O(n log n) ~ O(n^2)，不稳定排序算法。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 2;
        }
    }
}
