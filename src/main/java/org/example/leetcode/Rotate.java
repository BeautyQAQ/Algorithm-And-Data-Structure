package org.example.leetcode;

/**
 * No.48 旋转矩阵
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixNew = new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                matrixNew[j][n-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrixNew[i][j];
            }
        }
    }
}
