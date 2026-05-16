class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        dp = new int[row+1][col+1];

        for(int i = 0; i<=row; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                ans = Math.max(ans, solve(i, j, matrix));
            }
        }

        return ans;
    }

    private int solve(int i, int j, int[][] matrix){

        if(dp[i][j] != -1) return dp[i][j];

        int[][] directions = {{-1, 0}, {1,0}, {0,-1}, {0,1}};

        int ans = 1;
        for(int[] direction : directions){
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if(newRow >=0 && newCol >=0 && newRow < matrix.length 
            && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[i][j]){

                ans = Math.max(ans, 1 + solve(newRow, newCol, matrix));
            }
        }

        return dp[i][j] = ans;
    }
}
