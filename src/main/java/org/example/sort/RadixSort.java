package org.example.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 时间复杂度为 O(d(n+k))，稳定排序算法。
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            countingSortByExp(arr, exp);
        }
    }
    
    private static void countingSortByExp(int[] arr, int exp) {
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
    
}
