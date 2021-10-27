package org.example.leetCode;

import java.util.List;

/**
 * No.841 钥匙和房间
 */
public class CanVisitAllRooms {
    private int cnt = 0;
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        return cnt == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        visited[i] = true;
        cnt++;
        for (int j : rooms.get(i)) {
            if (!visited[j]) {
                dfs(rooms, j);
            }
        }
    }
}
