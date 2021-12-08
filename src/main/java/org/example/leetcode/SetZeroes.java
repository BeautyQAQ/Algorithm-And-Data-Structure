package org.example.leetcode;

/**
 * No.73 零矩阵
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 记录需要变0的行和列
                if (matrix[i][j]==0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
