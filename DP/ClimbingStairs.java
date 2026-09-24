package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public int temp(int n,int[]dp){
       if(n==0){
        return 1;
       }
       if(n<0){
        return 0;
       }
       if(dp[n]!=-1){
        return dp[n];
       }
       return dp[n]=temp(n-1,dp)+temp(n-2,dp);
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=temp(n,dp);
        return ans;
    }
    
}