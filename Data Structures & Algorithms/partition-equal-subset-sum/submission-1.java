class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;

        for(int i : nums){
            sum += i;
        }

        if(sum%2 != 0) return false;

        int amount = sum/2;

        boolean[][] dp = new boolean[n+1][amount+1];

        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=amount; j++){

                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
