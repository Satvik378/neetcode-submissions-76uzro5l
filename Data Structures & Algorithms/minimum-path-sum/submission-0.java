class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(m-1, n-1, grid);
    }

    int solve(int row, int col, int[][] grid){
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return Integer.MAX_VALUE; //invalid path
        if(dp[row][col] != -1) return dp[row][col];

        int left = solve(row, col-1, grid);
        int up = solve(row-1, col, grid);

        return dp[row][col]  = grid[row][col] + Math.min(left , up);
    }
}