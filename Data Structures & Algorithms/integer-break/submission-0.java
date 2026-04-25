class Solution {
    int[] cache;
    public int integerBreak(int n) {
        cache = new int[n+1];
        return solve(n, n);
    }

    int solve(int n, int num){
        if(cache[num]!=0) return cache[num];
        int res = (num==n) ? 0 : num;

        for(int i = 1; i<num; i++){
            int val = solve(n, i) * solve(n, num-i);
            res = Math.max(res, val);
        }

        return cache[num] = res;
    }
}