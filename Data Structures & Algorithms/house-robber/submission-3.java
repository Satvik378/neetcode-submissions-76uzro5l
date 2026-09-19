class Solution {
    Integer[] cache;
    public int rob(int[] nums) {
        cache = new Integer[nums.length];
        return dfs(0, nums);
    }

    private int dfs(int currentIndex, int[] nums){
        if(currentIndex >= nums.length){
            return 0;
        }

        if(cache[currentIndex]!=null) return cache[currentIndex];

        return cache[currentIndex] = Math.max(nums[currentIndex] + dfs(currentIndex+2, nums), 
            dfs(currentIndex+1, nums));
    }
}
