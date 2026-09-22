package Graphs;

import java.util.*;
public class SwimmingInRisingWater {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public int findparent(int node) {
        if (node == parent.get(node))
            return node;
        int up = findparent(parent.get(node));
        parent.set(node, up);
        return parent.get(node);
    }

    public boolean unionbysize(int u, int v) {
        int uu = findparent(u);
        int uv = findparent(v);
        if (uu == uv) {
            return true;
        } else if (size.get(uu) > size.get(uv)) {
            parent.set(uv, uu);
            size.set(uu, size.get(uu) + size.get(uv));
        } else if (size.get(uu) < size.get(uv)) {
            parent.set(uu, uv);
            size.set(uv, size.get(uu) + size.get(uv));
        } else {
            parent.set(uv, uu);
            size.set(uu, size.get(uu) + size.get(uv));
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            parent.add(i);
            size.add(1);
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int time = 0; time < n * n; time++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > time) {
                     continue;
                    }
                    int node = i * n + j;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                     if (ni >= 0 && ni < n &&
                        nj >= 0 && nj < n &&
                        grid[ni][nj] <= time) {
                        int nnode = ni * n + nj;
                        unionbysize(node, nnode);
                        }
                    }
                }
            }
            if (findparent(0) == findparent(n * n - 1)) {
                return time;
            }
        }
        return -1;
    }
}
