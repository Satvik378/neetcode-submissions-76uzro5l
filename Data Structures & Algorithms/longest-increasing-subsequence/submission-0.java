class Solution {
    public int lengthOfLIS(int[] nums) {
        //bottoms up dp
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){

                if(nums[i] < nums[j]){
                    //increasing subsequence.
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
