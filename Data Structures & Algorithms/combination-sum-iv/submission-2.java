class Solution {
    HashMap<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        return dfs(nums, target);
    }

    public int dfs(int[] nums, int totalLeft){
        if(totalLeft == 0) return 1;
        if(memo.containsKey(totalLeft)) return memo.get(totalLeft);
        int res = 0;

        for(int i : nums){
            if(i > totalLeft){
                break;
            }

            res += dfs(nums, totalLeft - i);
        }
        memo.put(totalLeft, res);
        return res;
    }
}