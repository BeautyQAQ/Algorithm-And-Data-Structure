package org.example.leetCode;

/**
 * No.733 图像渲染
 * 类似小岛问题,有一个二维矩阵,在给定一个坐标和数值[1,1,2],需要将坐标周围的可以连通的(值为1)数变成2
 */
public class FloodFill {
    private int oldColor;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        if (oldColor!=newColor) {
            dfs(image,sr,sc,newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        if (sr>=0&&sr<image.length&&sc>=0&&sc<image[0].length&&image[sr][sc]==oldColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int x = sr + dx[i], y = sc + dy[i];
                dfs(image, x, y, newColor);
            }
        }
    }
}
