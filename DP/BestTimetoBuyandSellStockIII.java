package DP;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
    public int profit(int i,int bought, int[][][]dp,int[] prices,int k,int atmost){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][bought][k]!=-1){
            return dp[i][bought][k];
        }
        int ans;
        if(bought==0){
            int buy=-prices[i]+profit(i+1,1,dp,prices,k,atmost);
            int skip=profit(i+1,0,dp,prices,k,atmost);
            ans=Math.max(buy,skip);
        }
        else{
            int sold=0;
            if(k<atmost){
            sold=prices[i]+profit(i+1,0,dp,prices,k+1,atmost);
            }
            int hold=profit(i+1,1,dp,prices,k,atmost);
            ans=Math.max(sold,hold);
        }
        return dp[i][bought][k]=ans;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
            Arrays.fill(dp[i][j],-1);
            }
        }
        return profit(0,0,dp,prices,0,2);
    }
}
