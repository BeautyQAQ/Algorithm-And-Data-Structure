package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.118 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows<=0){
            return triangle;
        }
        // 第一行数字为1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        // 从1开始循环,构建第二层往后
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preList = triangle.get(i-1);
            // 第一列数字1
            row.add(1);
            // 每行第二列开始赋值
            for (int j = 1; j < i; j++) {
                row.add(preList.get(j-1)+preList.get(j));
            }
            // i=j时,数字为1
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
