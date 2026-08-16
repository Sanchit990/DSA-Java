package Graphs;
import java.util.*;
class Solution {

    public boolean dfs(int node, List<List<Integer>> a,
                       boolean[] vis, boolean[] path) {

        vis[node] = true;
        path[node] = true;

        for (Integer i : a.get(node)) {

            if (!vis[i]) {
                if (dfs(i, a, vis, path))
                    return true;
            }
            else if (path[i]) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            a.add(new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            a.get(i[1]).add(i[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {
                if (dfs(i, a, vis, path))
                    return false;
            }
        }

        return true;
    }
}
