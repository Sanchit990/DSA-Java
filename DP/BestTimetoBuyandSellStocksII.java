package DP;

import java.util.Arrays;

public class BestTimetoBuyandSellStocksII {
     public int profit(int i, int bought,int[][]dp, int[]prices){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][bought]!=-1){
            return dp[i][bought];
        }
        int ans;
        if(bought==0){
            int buy=-prices[i]+profit(i+1,1,dp,prices);
            int skip=profit(i+1,0,dp,prices);
            ans=Math.max(buy,skip);
        }
        else{
            int sold=prices[i]+profit(i+1,0,dp,prices);
            int hold=profit(i+1,1,dp,prices);
            ans=Math.max(sold,hold);
        }
        return dp[i][bought]=ans;
    }
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int dp[][]=new int[n+1][2];
       for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
       } 
       return profit(0,0,dp,prices);
    }
}
