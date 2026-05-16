class Solution {
    public int maxSubArray(int[] nums) {
        //kadane's algo
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for(int i : nums){
            sum = sum + i;
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
        }

        return ans;
    }
}
