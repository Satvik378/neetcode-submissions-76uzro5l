class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        //MCM pattern.
        //find i and j
        // base condition.
        //k loop.
        // temp ans.
        int n = nums.length;
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;

        for(int i = 0; i<n; i++){
            temp[i+1] = nums[i];
        }

        dp = new int[n+2][n+2];
        for(int i = 0; i<n+2; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(1, nums.length, temp);
    }

    int solve(int i, int j, int[] nums){

        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int left, right;

            if(dp[i][k-1] != -1){
                left = dp[i][k-1];
            }
            else{
                dp[i][k-1] = solve(i, k-1, nums);
                left = dp[i][k-1];
            }

            if(dp[k+1][j] != -1){
                right = dp[k+1][j];
            }
            else{
                dp[k+1][j] = solve(k+1, j, nums);
                right = dp[k+1][j];
            }

            int coins = nums[i-1] * nums[k] * nums[j+1];

            int temp = coins + left + right;

            ans = Math.max(ans, temp);
        }

        return dp[i][j] = ans;
    }
}
