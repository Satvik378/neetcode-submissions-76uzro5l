class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];

        for(int i = 0; i<prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(1, 0,prices);
    }

    int solve(int isBuy, int index,int[] prices){
        if(index >= prices.length) return 0;

        if(dp[index][isBuy] != -1) return dp[index][isBuy];

        int cooldown = solve(isBuy, index+1, prices);

        if(isBuy == 1){
            //buy
            int buy = solve(0, index+1, prices) - prices[index];
            dp[index][isBuy] = Math.max(buy, cooldown);
        }
        else{
            int sell = solve(1, index+2, prices) + prices[index];
            dp[index][isBuy] = Math.max(sell, cooldown);
        }

        return dp[index][isBuy];
    }
}
