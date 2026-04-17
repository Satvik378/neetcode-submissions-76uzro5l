class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;
        for(int i : nums){
            sum+= i;
        }

        if(target > sum || (sum+target)%2 !=0 || (sum+target) < 0){
            return 0;
        }

        int range = (target+sum)/2;

        int[][] dp = new int[n+1][range+1];
        
        for(int i = 0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<=n; i++){
            for(int j=0; j<=range; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //dp[n][target] contains count of subset sum.
        // count of subset  = target + sum /2; 

        return dp[n][range];
    }
}
