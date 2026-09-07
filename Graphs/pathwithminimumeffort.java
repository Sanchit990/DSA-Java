package Graphs;
import java.util.*;
class Solution {
    class helper {
        int i;
        int j;
        int dis;
        helper(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<helper> q = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        dist[0][0] = 0;
        q.offer(new helper(0, 0, 0));
        while (!q.isEmpty()) {
            helper obj = q.poll();
            int i = obj.i;
            int j = obj.j;
            int dis = obj.dis;
            if (i == m - 1 && j == n - 1) {
                return dis;
            }
            if (i + 1 < m) {
                int newdis = Math.abs(heights[i][j] - heights[i + 1][j]);
                int newEffort = Math.max(dis, newdis);
                if (newEffort < dist[i + 1][j]) {
                    dist[i + 1][j] = newEffort;
                    q.offer(new helper(i + 1, j, newEffort));
                }
            }
            if (i - 1 >= 0) {
                int newdis = Math.abs(heights[i][j] - heights[i - 1][j]);
                int newEffort = Math.max(dis, newdis);
                if (newEffort < dist[i - 1][j]) {
                    dist[i - 1][j] = newEffort;
                    q.offer(new helper(i - 1, j, newEffort));
                }
            }
            if (j + 1 < n) {
                int newdis = Math.abs(heights[i][j] - heights[i][j + 1]);
                int newEffort = Math.max(dis, newdis);
                if (newEffort < dist[i][j + 1]) {
                    dist[i][j + 1] = newEffort;
                    q.offer(new helper(i, j + 1, newEffort));
                }
            }
            if (j - 1 >= 0) {
                int newdis = Math.abs(heights[i][j] - heights[i][j - 1]);
                int newEffort = Math.max(dis, newdis);
                if (newEffort < dist[i][j - 1]) {
                    dist[i][j - 1] = newEffort;
                    q.offer(new helper(i, j - 1, newEffort));
                }
            }
        }
        return 0;
    }
}