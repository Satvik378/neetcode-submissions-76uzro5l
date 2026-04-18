class Solution {
    HashMap<Integer, Integer> map;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        map = new HashMap<>();
        map.put(0, 1);
        return dfs(nums, target);
    }

    public int dfs(int[] nums, int totalLeft){

        if(map.containsKey(totalLeft)) return map.get(totalLeft);
        if(totalLeft == 0) return 1;

        int res = 0;

        for(int i : nums){

            if(totalLeft < i){
                break;
            }
            res += dfs(nums, totalLeft-i);
        }
        map.put(totalLeft, res);
        return res;
    }
}