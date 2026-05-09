class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(m-1, n-1, obstacleGrid);
    }

    int solve(int row, int col, int[][] obstacleGrid){
        if(row == 0 && col == 0){
            return obstacleGrid[row][col] != 1 ? 1 : 0;
        }

        if(row <0 || col <0 || obstacleGrid[row][col] == 1){
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int left = solve(row, col-1, obstacleGrid);
        int up = solve(row-1, col, obstacleGrid);

        return dp[row][col] = left + up; 
    }
}