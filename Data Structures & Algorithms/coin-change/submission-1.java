class Solution {
    public int coinChange(int[] coins, int amount) {
        // knapsack pattern
        // fill first row as well.
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j < amount + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
            if (j >= 1) {
                if (j % coins[0] == 0) {
                    dp[1][j] = j / coins[0];
                } else {
                    dp[1][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for(int i = 2; i<=n; i++){
            for(int j = 1; j<=amount; j++){

                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j], 
                                1+dp[i][j-coins[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount] != Integer.MAX_VALUE-1 ? dp[n][amount] : -1;
    }
}
