class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), 0, nums, target); 
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> currentList,
     int index, int[] nums, int target){

        if(target == 0){
            res.add(new ArrayList<>(currentList));
            return;
        }

        if(index >= nums.length || target < 0){
            return;
        }

        currentList.add(nums[index]);

        dfs(res, currentList, index,nums, target - nums[index]);

        currentList.remove(currentList.size()-1);

        dfs(res, currentList, index+1,nums, target);
    }
}
