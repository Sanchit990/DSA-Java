package Graphs;
class Solution {
    int count=0;
    public void dfs(int i,int j,boolean [][]vis,char[][]grid){
        vis[i][j]=true;
        if(i+1<grid.length&&grid[i+1][j]=='1'){
            if(!vis[i+1][j])
            dfs(i+1,j,vis,grid);
        }
        if(i-1>=0&&grid[i-1][j]=='1'){
            if(!vis[i-1][j])
            dfs(i-1,j,vis,grid);
        }
        if(j+1<grid[0].length&&grid[i][j+1]=='1'){
            if(!vis[i][j+1])
            dfs(i,j+1,vis,grid);
        }
        if(j-1>=0&&grid[i][j-1]=='1'){
            if(!vis[i][j-1
            ])
            dfs(i,j-1,vis,grid);
        }
        return;
    }

    public int numIslands(char[][] grid) {
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j]&&grid[i][j] == '1'){
                dfs(i,j,vis,grid);
                count++;
                }
            }
        }
        return count;
    }
}