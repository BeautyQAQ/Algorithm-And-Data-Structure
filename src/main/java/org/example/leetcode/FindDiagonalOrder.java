package org.example.leetcode;

/**
 * No.498 对角线遍历
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat==null||mat.length==0) {
            return new int[0];
        }
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m*n];
        int[][] move = new int[][]{{-1,1},{1,-1}};
        int row = 0, col = 0, k=0; // k的值范围为0,1
        for (int i = 0; i < m*n; i++) {
            result[i] = mat[row][col];
            row+=move[k][0]; // 变换行
            col+=move[k][1]; // 变换列
            if(row>=m){
                row=m-1;col+=2;k=1-k; // 到达左下角的点，将其变为该边界点左边的坐标
            }
            if(col>=n){
                col=n-1;row+=2;k=1-k; // 到达右上角的点，将其变为该边界点下面的坐标
            }
            if(row<0){
                row=0;k=1-k; // row到达左上边界时，不能在向右上移动了，需改变遍历的方向
            }
            if(col<0){
                col=0;k=1-k; // col到达左下边界时，不能再向左下移动了，需改变遍历的方向
            }         
        }
        return result;
    }
}
