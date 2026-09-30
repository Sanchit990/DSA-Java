package DP;
public class UniquePathsII {
    public int dpp(int i,int j,int [][]dp,int[][]obstacleGrid){
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length){
            return 0;
            }
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1&&obstacleGrid[i][j]==0){
            return 1;
        }
        if(obstacleGrid[i][j]!=0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=dpp(i+1,j,dp,obstacleGrid);
        int right=dpp(i,j+1,dp,obstacleGrid);
        dp[i][j]=down+right;
        return dp[i][j];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
    }
    return dpp(0,0,dp,obstacleGrid);
    }    
}