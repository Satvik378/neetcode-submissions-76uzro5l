class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currentList,
        boolean[] visited, int[] nums){

            if(currentList.size() == nums.length){
                res.add(new ArrayList<>(currentList));
                return;
            }

            for(int i = 0; i <nums.length; i++){

                if(visited[i]) continue;

                if(i > 0  && nums[i] == nums[i-1] && !visited[i-1]) continue;

                currentList.add(nums[i]);
                visited[i] = true;
                dfs(res, currentList, visited, nums);
                currentList.remove(currentList.size()-1);
                visited[i] = false;
            }
            
    }
}