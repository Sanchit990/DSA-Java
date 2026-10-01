package DP;

import java.util.Arrays;

public class UniquePaths {
    public int numberofpath(int i,int j, int dp[][],int m , int n){
        if(i>m||j>n){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=numberofpath(i+1,j,dp,m,n);
        int right=numberofpath(i,j+1,dp,m,n);
        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return numberofpath(0,0,dp,m,n);
    }
}
