class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0, globalMax = nums[0];
        int currentMin = 0, globalMin = nums[0];

        int total = 0;

        for(int i : nums){

            total += i;

            //max
            currentMax = Math.max(i, currentMax + i);
            globalMax = Math.max(globalMax, currentMax);

            //min
            currentMin = Math.min(i, currentMin+i);
            globalMin = Math.min(globalMin, currentMin);
        }

        if(globalMax < 0) return globalMax;

        return Math.max(globalMax, total - globalMin);
    }
}