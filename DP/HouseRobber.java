package DP;

import java.util.Arrays;
public class HouseRobber {
    int dps(int n,int dp[],int nums[]){
       if(n>=nums.length){
        return 0;
       }
       if(dp[n]!=-1){
        return dp[n];
       }
       int r=nums[n]+dps(n+2,dp,nums);
       int s=dps(n+1,dp,nums);
       return dp[n]=Math.max(r,s);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dps(0,dp,nums);
    }
}
