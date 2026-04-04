class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(res, new ArrayList<>(), 0, candidates, target);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currentList,
        int index, int[] nums, int target){

            if(target == 0){
                res.add(new ArrayList<>(currentList));
                return;
            }

            if(target < 0 || index >= nums.length){
                return;
            }

            currentList.add(nums[index]);
            dfs(res, currentList, index+1, nums, target - nums[index]);

            currentList.remove(currentList.size()-1);

            while(index+1 < nums.length && nums[index] == nums[index+1]){
                index++;
            }
            dfs(res, currentList, index+1, nums, target);

    }
}
