package org.example.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * Description:冒泡排序
     *
     * @param array 需要排序的数组
     * @author JourWon
     * @date 2019/7/11 9:54
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
    
        int length = array.length;
    
        // 外层循环控制比较轮数i
        for (int i = 0; i < length; i++) {
            // 内层循环控制每一轮比较次数，每进行一轮排序都会找出一个较大值
            // (array.length - 1)防止索引越界，(array.length - 1 - i)减少比较次数
            for (int j = 0; j < length - 1 - i; j++) {
                // 前面的数大于后面的数就进行交换
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    
    }
    
}
