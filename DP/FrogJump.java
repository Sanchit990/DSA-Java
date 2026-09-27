package DP;

import java.util.Arrays;

public class FrogJump {
    public boolean temp(int i, int k, int[] stones, int[][] dp) {
        if(i == stones.length - 1) {
            return true;
        }
        if(dp[i][k] != -1) {
            return dp[i][k] == 1;
        }
        for(int jump = k - 1; jump <= k + 1; jump++) {
            if(jump <= 0) {
                continue;
            }
            int nextPosition = stones[i] + jump;
            for(int j = i + 1; j < stones.length; j++) {
                if(stones[j] == nextPosition) {
                    if(temp(j, jump, stones, dp)) {
                        dp[i][k] = 1;
                        return true;
                    }
                    break;
                }
                if(stones[j] > nextPosition) {
                    break;
             }
        }
        }
        dp[i][k] = 0;
        return false;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return temp(0, 0, stones, dp);
    }
}
