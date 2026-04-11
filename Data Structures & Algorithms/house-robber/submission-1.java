class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    private int solve(int index, int[] nums, int[] dp){

        if(index >= nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        //current house robbed
        dp[index] =  Math.max(nums[index] + solve(index+2, nums, dp),
                        solve(index+1, nums, dp));

        return dp[index];

    }
}
