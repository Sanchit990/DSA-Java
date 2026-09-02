package Graphs;

import java.util.*;

class Solution {

    class pair {
        int node;
        int dist;

        pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = grid[i][0];
            int v = grid[i][1];

            a.get(u).add(v);
            a.get(v).add(u);
        }

        Queue<pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(new pair(0, 0));
        vis[0] = true;

        while (!q.isEmpty()) {

            pair curr = q.poll();

            int node = curr.node;
            int dist = curr.dist;

            if (node == n - 1) {
                return dist;
            }

            for (int neighbour : a.get(node)) {

                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(new pair(neighbour, dist + 1));
                }
            }
        }

        return -1;
    }
}