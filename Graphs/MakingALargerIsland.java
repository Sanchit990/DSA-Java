package Graphs;

import java.util.*;
public class MakingALargerIsland {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public int findparent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int up = findparent(parent.get(node));
        parent.set(node, up);
        return parent.get(node);
    }
    public boolean unionbysize(int u, int v){
        int upu = findparent(u);
        int upv = findparent(v);
        if(upu == upv){
            return true;
        }
        if(size.get(upu) > size.get(upv)){
            parent.set(upv, upu);
            size.set(upu, size.get(upu) + size.get(upv));
        }
        else{
            parent.set(upu, upv);
            size.set(upv, size.get(upu) + size.get(upv));
        }
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i < n*n; i++){
            parent.add(i);
            size.add(1);
        }
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int node = i * n + j;
                for(int k = 0; k < 4; k++){
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                    if(ni >= 0 && ni < n &&
                       nj >= 0 && nj < n &&
                       grid[ni][nj] == 1){
                        int adjNode = ni * n + nj;
                        unionbysize(node, adjNode);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                int total = 1;
                Set<Integer> components = new HashSet<>();
                for(int k = 0; k < 4; k++){
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                    if(ni >= 0 && ni < n &&
                       nj >= 0 && nj < n &&
                       grid[ni][nj] == 1){
                        int adjNode = ni * n + nj;
                        int parentNode = findparent(adjNode);
                        if(components.add(parentNode)){
                            total += size.get(parentNode);
                        }
                    }
                }
                ans = Math.max(ans, total);
            }
        }
        if(ans == 0){
            return n * n;
        }
        return ans;
    }
}
