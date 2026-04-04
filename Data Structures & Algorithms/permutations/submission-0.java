class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(res, visited, new ArrayList<>(), nums);

        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] visited, 
            List<Integer> currentList, int[] nums){
        
        if(currentList.size() == nums.length){
            res.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i<nums.length; i++){

            if(visited[i]) continue;

            currentList.add(nums[i]);
            visited[i] = true;
            dfs(res, visited, currentList, nums);
            
            currentList.remove(currentList.size()-1);
            visited[i] = false;
        } 
    }
}
