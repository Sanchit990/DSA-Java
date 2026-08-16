 package Graphs;
 import java.util.*;
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]>q=new ArrayDeque<>();
        int ans[][]=new int[isWater.length][isWater[0].length];
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
            while(!q.isEmpty()){
                int[]a=q.poll();
                int i=a[0];
                int j=a[1];
                if(i+1<isWater.length&&ans[i+1][j]==-1){
                    ans[i+1][j]=ans[i][j]+1;
                    q.offer(new int[]{i+1,j});
                }
                if(j+1<isWater[0].length&&ans[i][j+1]==-1){
                    ans[i][j+1]=ans[i][j]+1;
                    q.offer(new int[]{i,j+1});
                }
                if(i-1>=0&&ans[i-1][j]==-1){
                    ans[i-1][j]=ans[i][j]+1;
                    q.offer(new int[]{i-1,j});
                }
                if(j-1>=0&&ans[i][j-1]==-1){
                    ans[i][j-1]=ans[i][j]+1;
                    q.offer(new int[]{i,j-1});
                }
            } 
        return ans;
    }
}