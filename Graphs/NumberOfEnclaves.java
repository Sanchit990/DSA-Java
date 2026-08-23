package Graphs;
import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
       Queue<int[]>q=new LinkedList<>();
       int m=grid.length;
       int n=grid[0].length;
       for(int i=0;i<m;i++) {
        if(grid[i][0]==1){
            q.offer(new int[]{i,0});
            grid[i][0]=-1;
        }
        if(grid[i][n-1]==1){
            q.offer(new int[]{i,n-1});
            grid[i][n-1]=-1;
        }
       }
       for(int j=0;j<n;j++){
        if(grid[0][j]==1){
            q.offer(new int[]{0,j});
            grid[0][j]=-1;
        }
        if(grid[m-1][j]==1){
            q.offer(new int[]{m-1,j});
            grid[m-1][j]=-1;//-1 indicates this is a save point , start from here(possible ans)
        }
       }
       while(!q.isEmpty()){
        int[]a=q.poll();
        int i=a[0];
        int j=a[1];
        if(i+1<m&&grid[i+1][j]==1){
            q.offer(new int[]{i+1,j});
            grid[i+1][j]=-1;
        }
        if(i-1>=0&&grid[i-1][j]==1){
            q.offer(new int[]{i-1,j});
            grid[i-1][j]=-1;
        }
        if(j+1<n&&grid[i][j+1]==1){
            q.offer(new int[]{i,j+1});
            grid[i][j+1]=-1;
        }
        if(j-1>=0&&grid[i][j-1]==1){
            q.offer(new int[]{i,j-1});
            grid[i][j-1]=-1;
        }
       }
       int count=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                count++;
            }
        }
       }
       return count;
    }
}