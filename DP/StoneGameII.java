package DP;

import java.util.Arrays;

public class StoneGameII {
    public int take(int n,int M,int chance,int[][][] dp,int[]piles){
        if(n>piles.length){
            return 0;
        }
        if(dp[n][M][chance]!=-1){
            return dp[n][M][chance];
             }
             int ans;
         if(chance==0){
            int Alice=0;
            int sum=0;
            for(int i=1;i<=2*M&&n+i<=piles.length;i++){
             sum+=piles[n+i-1];
             int cur=sum+take(n+i,Math.max(i,M),1,dp,piles);
             Alice=Math.max(Alice,cur);
         }
         ans=Alice;
         }
         else {
            int Bob = Integer.MAX_VALUE;
            for(int i=1;i<=2*M;i++){
             int cur=take(n+i,Math.max(i,M),0,dp,piles);
             Bob=Math.min(cur,Bob);
         }
         ans=Bob;
         }
         return dp[n][M][chance]=ans;
    }
    public int stoneGameII(int[] piles) {
        if(piles.length==1){
            return piles[0];
        }
        int n=piles.length;
        int dp[][][]=new int[n+1][n+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return take(0,1,0,dp,piles);
    }
}
