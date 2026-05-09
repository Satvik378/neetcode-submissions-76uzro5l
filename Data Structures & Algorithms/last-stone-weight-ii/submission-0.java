class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        //divide stones into 2 subsets such that the diff 
        //of their sum is minimal.

        int m = stones.length;
        int sum = 0;

        for(int i : stones){
            sum+=i;
        }

        boolean[][] dp = new boolean[m+1][sum+1];
        
        for(int i = 0; i<=m; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=sum; j++){

                if(stones[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //last row of dp depicts taking all elements what sum can be formed.
        int res = Integer.MAX_VALUE;

        for(int i = 0; i<=sum/2; i++){ //min sum
            if(dp[m][i]){
                int subset = sum - i;
                res = Math.min(res, subset - i);
            }
        }

        return res;

    }
}