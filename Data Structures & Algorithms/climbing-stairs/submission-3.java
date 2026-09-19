class Solution {
    Integer[] cache;
    public int climbStairs(int n) {
        cache = new Integer[n];
        return dfs(0,n);
    }

    private int dfs(int currIndex, int n){
        if(currIndex >= n){
            return currIndex == n ? 1 : 0;
        }

        if(cache[currIndex]!= null) return cache[currIndex];

        return cache[currIndex] = dfs(currIndex+1, n) + dfs(currIndex+2, n);
    }
}
