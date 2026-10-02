package DP;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int n ,int stop,int []dp , int[]nums){
        if(n>=stop){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int rob=nums[n]+rob(n+2,stop,dp,nums);
        int skip=rob(n+1,stop,dp,nums);
        return dp[n]=Math.max(rob,skip);
    }

    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int a= rob(0,n-1,dp,nums);
        int b=rob(1,n,dp2,nums);
        return Math.max(a,b);
    }
}
