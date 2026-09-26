class Solution {
    Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        memo = new Integer[stoneValue.length];
        int res = dfs(stoneValue, 0); 

        if(res > 0){
            return "Alice";
        }
        else if(res < 0){
            return "Bob";
        }

        return "Tie";
    }

    private int dfs(int[] stoneValues, int index){
        if(index>=stoneValues.length) return 0;

        if(memo[index]!=null) return memo[index]; 

        int take=0;
        int bestValue = Integer.MIN_VALUE;
        for(int i = index; i<stoneValues.length && i<index+3; i++){
            take += stoneValues[i];

            bestValue = Math.max(bestValue, take-dfs(stoneValues, i+1));
        }
        memo[index] = bestValue;
        return bestValue;
    }
}