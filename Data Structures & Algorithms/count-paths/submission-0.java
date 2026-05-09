class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp  = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1);
    }

    int solve(int row, int col){
        
        if(row == 0 && col == 0) return 1; 
        //successful reaching the destination.

        if(row < 0 || col < 0) return 0;
        if(dp[row][col]!= -1) return dp[row][col];

        int left = solve(row, col-1);
        int up = solve(row-1, col);

        return dp[row][col] = left+up;

    }
}
