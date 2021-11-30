package org.example.Sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Description: 快速排序
     *
     * @param array
     * @return void
     * @author JourWon
     * @date 2019/7/11 23:39
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    private void quickSort(int[] array, int left, int right) {
        if (array == null || left >= right || array.length <= 1) {
            return;
        }
        int mid = partition(array, left, right);
        quickSort(array, left, mid);
        quickSort(array, mid + 1, right);
    }


    private int partition(int[] array, int left, int right) {
        int temp = array[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= array[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[left]，则填坑
            if (left < right) {
                array[left] = array[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= array[left] && left < right) {
                ++left;
            }
            if (left < right) {
                array[right] = array[left];
                --right;
            }
        }
        array[left] = temp;
        return left;
    }

}
