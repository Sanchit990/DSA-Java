package DP;

import java.util.Arrays;

public class StoneGame {
    public int take(int n,int stop,int [][][]dp,int chance,int[]piles){
        if(n>stop){
            return 0;
        }
        if(dp[n][stop][chance]!=-1){
            return dp[n][stop][chance];
        }
        if(chance==0){//Alice's turn 
        int front=piles[n]+take(n+1,stop,dp,1,piles);
        int back=piles[stop]+take(n,stop-1,dp,1,piles);
        return dp[n][stop][chance]= Math.max(front,back);//alice has to maximize to win
        }
        else{//Bob's turn 
        int front=piles[n]+take(n+1,stop,dp,0,piles);
        int back=piles[stop]+take(n,stop-1,dp,0,piles);
        return dp[n][stop][chance]=Math.min(front,back);//bob has to minimize to win
        }
    } 
    public boolean stoneGame(int[] piles) {
        int total=0;
        int n=piles.length;
        int dp[][][]=new int[n+1][n+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i:piles){
            total+=i;
        }
        int ans=take(0,piles.length-1,dp,0,piles);
        if(ans>total/2){
            return true;
        }
        return false;
    }
}
