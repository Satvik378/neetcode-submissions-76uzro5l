class Solution {
    Integer[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new Integer[cost.length];
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    private int dfs(int currIndex, int[] cost){

        if(currIndex >= cost.length){
            return 0;
        }
        if(cache[currIndex]!= null) return cache[currIndex];

        return cache[currIndex] = cost[currIndex] + 
        Math.min(dfs(currIndex+1, cost), dfs(currIndex+2, cost));
    }
}
