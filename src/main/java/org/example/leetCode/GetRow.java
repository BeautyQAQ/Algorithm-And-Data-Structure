package org.example.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.119 杨辉三角 II
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class GetRow {
    public static List<Integer> getRow(int rowIndex) {
        // 动态规划, 用上一次的结果计算下一次的结果
        List<Integer> list = new ArrayList<>();
        // 第一列
        list.add(1);
        if (rowIndex==0) {
            return list;
        }
        // 获取上一次的结果
        List<Integer> listTemp = getRow(rowIndex-1);
        // 遍历上一次的结果, 从第二列到最后一列
        for (int i = 1; i < listTemp.size(); i++) {
            // 如果不是第一列和最后一列, 第n行第m列等于上一行m-1列+第m列
            list.add(listTemp.get(i-1)+listTemp.get(i));
        }
        // 最后一列
        list.add(1);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        for (Integer integer : row) {
            System.out.println(integer);
        }
    }
}
