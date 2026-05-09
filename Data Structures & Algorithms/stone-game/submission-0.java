class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        dp = new int[n+1][n+1];

        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, n-1, piles) > 0? true : false;

    }

    int solve(int left, int right, int[] piles){

        if(left ==  right){
            //one pile left
            //current player takes it.
            return piles[left];
        }

        if(dp[left][right] != Integer.MIN_VALUE) return dp[left][right];

        int i = piles[left] - solve(left+1, right, piles);
        int j = piles[right] - solve(left, right-1, piles);

        return dp[left][right] = Math.max(i, j);
    }
}