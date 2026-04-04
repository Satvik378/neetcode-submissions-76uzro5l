class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int total, int index){
        if(index == nums.length) return total;

        return dfs(nums, total ^nums[index], index+1) + 
                dfs(nums, total, index+1);
    }
}