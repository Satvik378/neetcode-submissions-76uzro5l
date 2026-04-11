class Solution {
    public int rob(int[] nums) {
        
        Integer[][] dp = new Integer[nums.length][2];

        if(nums.length == 1) return nums[0];

        //flag for first house robbed -> 0 or 1.
        return Math.max(solve(0, nums, dp, 1), solve(1, nums, dp, 0));
    }

    public int solve(int index, int[] nums, Integer[][] dp, int flag){

        if(index>= nums.length || 
                (flag==1 && index == nums.length-1)) return 0;
        
        if(dp[index][flag] != null) return dp[index][flag];

        dp[index][flag] = Math.max(nums[index] + solve(index+2, nums, dp, flag),
                                    solve(index+1, nums, dp, flag));

        return dp[index][flag];
    }
}
