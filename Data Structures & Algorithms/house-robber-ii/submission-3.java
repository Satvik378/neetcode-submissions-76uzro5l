class Solution {
    Integer[][] cache;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        //a flag if the firstHouse is included or not.
        cache = new Integer[nums.length][2];
        return Math.max(dfs(0, nums, 1), dfs(1, nums, 0));
    }

    private int dfs(int currentIndex, int[] nums, int firstIndexIncluded){
        if(firstIndexIncluded == 1 && currentIndex >= nums.length-1 ||
        (firstIndexIncluded == 0 && currentIndex >= nums.length)){
            return 0;
        }

        if(cache[currentIndex][firstIndexIncluded]!=null) return cache[currentIndex][firstIndexIncluded];

        return cache[currentIndex][firstIndexIncluded] = Math.max(nums[currentIndex] + dfs(currentIndex+2, nums, firstIndexIncluded),
            dfs(currentIndex+1, nums, firstIndexIncluded));
    }
}
