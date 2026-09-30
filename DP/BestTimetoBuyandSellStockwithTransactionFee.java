package DP;

public class BestTimetoBuyandSellStockwithTransactionFee {
     /*int profit(int i, int bought,int[][]dp,int[]prices,int fee){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][bought]!=-1){
            return dp[i][bought];
        }
        int ans;
        if(bought==0){
            int buy=-prices[i]+profit(i+1,1,dp,prices,fee);
            int skip=profit(i+1,0,dp,prices,fee);
            ans=Math.max(buy,skip);
        }
        else{
            int sold=prices[i]-fee+profit(i+1,0,dp,prices,fee);
            int hold=profit(i+1,1,dp,prices,fee);
            ans=Math.max(hold,sold);
        }
        return dp[i][bought]=ans;
    }*/
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int hold=-prices[0];
            int cash=0;
            for(int i=1;i<n;i++){
                int prev=cash;
                //max profit through buying
                cash=Math.max(cash,hold+prices[i]-fee);
                //max profit through selling 
                hold=Math.max(hold,prev-prices[i]);
            }
            return cash;
        }
}
