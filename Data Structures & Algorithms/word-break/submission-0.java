class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i = n-1; i>=0; i--){
            for(String str : wordDict){

                if(i+str.length() <= n && s.substring(i, i+str.length()).
                                            equals(str) && dp[i+str.length()]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
