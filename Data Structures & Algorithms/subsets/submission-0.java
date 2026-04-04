class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        dfs(res, new ArrayList<>(), 0, nums); 
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currentList, 
    int index, int[] nums){

        if(index == nums.length){
            res.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[index]);
        dfs(res, currentList, index+1, nums); //include
        currentList.remove(currentList.size()-1);
        dfs(res, currentList, index+1, nums); //exclude
    }
}
