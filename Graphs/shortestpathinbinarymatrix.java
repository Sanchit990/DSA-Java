package Graphs
import java.util.*;
class Solution {
    class helper{
        int i=0;
        int j=0;
        int dis;
        helper(int i , int j,int dis){
            this.i=i;
            this.j=j;
            this.dis=dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
               int n=grid.length;
        if(grid[0][0]==1){
            return -1;
        }
        if(grid[0][0]==0&&grid.length==1){
            return 1;
        }
       PriorityQueue<helper>q=new PriorityQueue<helper>((x,y)->x.dis-y.dis);
       q.offer(new helper(0,0,0));
       int[][]dist=new int[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            dist[i][j]=Integer.MAX_VALUE;
        }
       }
       while(!q.isEmpty()){
        helper obj=q.poll();
        int i=obj.i;
        int j=obj.j;
        int dis=obj.dis;
        if(i+1<n&&grid[i+1][j]==0){
            int newdis=dis+1;
            if(newdis<dist[i+1][j]){
                dist[i+1][j]=newdis;
                q.add(new helper(i+1,j,newdis));
            }
        }
        if(i-1>=0&&grid[i-1][j]==0){
            int newdis=dis+1;
            if(newdis<dist[i-1][j]){
                dist[i-1][j]=newdis;
                q.add(new helper(i-1,j,newdis));
            }
        }
            if(j+1<n&&grid[i][j+1]==0){
            int newdis=dis+1;
            if(newdis<dist[i][j+1]){
                dist[i][j+1]=newdis;
                q.add(new helper(i,j+1,newdis));
            }
            }
            if(j-1>=0&&grid[i][j-1]==0){
            int newdis=dis+1;
            if(newdis<dist[i][j-1]){
                dist[i][j-1]=newdis;
                q.add(new helper(i,j-1,newdis));
            }
            }
            if(i-1>=0 && j-1>=0 && grid[i-1][j-1]==0){
                int newdis=dis+1;
                if(newdis<dist[i-1][j-1]){
                    dist[i-1][j-1]=newdis;
                q.add(new helper(i-1,j-1,newdis));
                }
            }
            if(i-1>=0 && j+1<n && grid[i-1][j+1]==0){
                int newdis=dis+1;
                if(newdis<dist[i-1][j+1]){
                    dist[i-1][j+1]=newdis;
                q.add(new helper(i-1,j+1,newdis));
                }
            }
           if(i+1<n && j-1>=0 && grid[i+1][j-1]==0){
                int newdis=dis+1;
                if(newdis<dist[i+1][j-1]){
                    dist[i+1][j-1]=newdis;
                q.add(new helper(i+1,j-1,newdis));
                }
            }
            if(i+1<n && j+1<n&& grid[i+1][j+1]==0){
                int newdis=dis+1;
                if(newdis<dist[i+1][j+1]){
                    dist[i+1][j+1]=newdis;
                q.add(new helper(i+1,j+1,newdis));
                }
            }
       }
       if(dist[n-1][n-1]==Integer.MAX_VALUE){
        return -1;
       }
       return dist[n-1][n-1]+1;
    }
}