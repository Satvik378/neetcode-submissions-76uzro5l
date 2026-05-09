class Solution {
    int[][] dp;
    int[] suffix;
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        //changing vars: index, M

        dp = new int[n][n+1];
        suffix = new int[n];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        //for suffix calc makes sense to start from back.
        suffix[n-1] = piles[n-1];

        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1] + piles[i]; 
        }

        return solve(0, 1, piles);
    }

    int solve(int i, int M, int[] piles){

        if(i >= piles.length) return 0;

        if(2*M >= piles.length-i){
            return suffix[i];
        }

        if(dp[i][M] != -1) return dp[i][M];
        int res = 0;

        for(int X = 1; X<= 2*M; X++){

            int opponent = solve(i + X, Math.max(M, X), piles);
            int current = suffix[i] - opponent;
            res = Math.max(res, current);
        }

        return dp[i][M] = res;
    }
}