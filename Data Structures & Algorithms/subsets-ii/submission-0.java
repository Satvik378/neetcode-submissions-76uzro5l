class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(res, new ArrayList<>(), 0, nums);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currentList, 
            int index, int[] nums){
        
        if(nums.length == index){
            res.add(new ArrayList<>(currentList));
            return;
        }


        currentList.add(nums[index]);
        dfs(res, currentList, index+1, nums);

        currentList.remove(currentList.size()-1);

        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        dfs(res, currentList, index+1, nums);
    }
}
