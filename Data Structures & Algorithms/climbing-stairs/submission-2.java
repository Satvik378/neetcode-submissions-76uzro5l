class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n, 0);
    }

    public int dfs(int dstSum, int currSum){
        if(dstSum <= currSum){
            return dstSum == currSum ? 1 : 0;
        }

        if(cache[currSum] != -1) return cache[currSum];

        return cache[currSum] = dfs(dstSum, currSum+1) + dfs(dstSum, currSum+2);
    }
}
