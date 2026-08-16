package Graphs;
import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
       Queue<int[]>q=new ArrayDeque<>();
       int ans[][]=new int[mat.length][mat[0].length];
       for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]==0){
                ans[i][j]=0;
                q.offer(new int[]{i,j});
            }
            else{
                ans[i][j]=-1;
            }
        }
       } 
       while(!q.isEmpty()){
            int obj[]=q.poll();
            int a=obj[0];
            int b=obj[1];
            if(a+1<mat.length&&ans[a+1][b]==-1){
                ans[a+1][b]=ans[a][b]+1;
                q.offer(new int[]{a+1,b});
            }
            if(a-1>=0&&ans[a-1][b]==-1){
                ans[a-1][b]=ans[a][b]+1;
                q.offer(new int[]{a-1,b});
            }
            if(b+1<mat[0].length&&ans[a][b+1]==-1){
                ans[a][b+1]=ans[a][b]+1;
                q.offer(new int[]{a,b+1});
            }
            if(b-1>=0&&ans[a][b-1]==-1){
                ans[a][b-1]=ans[a][b]+1;
                q.offer(new int[]{a,b-1});
            }
        }
       return ans;
    }
}