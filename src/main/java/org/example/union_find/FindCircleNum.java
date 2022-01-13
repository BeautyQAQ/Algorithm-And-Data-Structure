package org.example.union_find;

import java.util.TreeSet;

/**
 * No.547 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c
 * 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而
 * isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 */
public class FindCircleNum {
    private interface UF {
        int getSize();
        boolean isConnected(int p, int q);
        void unionElements(int p, int q);
    }

    private class UnionFind1 implements UF {

        private int[] id;
        public UnionFind1(int size){
            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        @Override
        public int getSize() {
            return id.length;
        }

        private int find(int p){
            if (p<0 || p>=id.length) {
                throw new IllegalArgumentException("p is out of bound.");
            }
            return id[p];
        }

        @Override
        public boolean isConnected(int p, int q) {
            return find(p)==find(q);
        }

        @Override
        public void unionElements(int p, int q) {
            int pID = find(p);
            int qID = find(q);
            if(pID == qID){
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i]==pID) {
                    id[i] = qID;
                }
            }  
        }
    }

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        UnionFind1 uf = new UnionFind1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j]==1) {
                    uf.unionElements(i, j);
                }
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }
}
