class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1; //empty string.

        for(int i = len-1; i>=0; i--){

            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }
            else{

                dp[i] = dp[i+1]; //1 way, single digit.

                //double digits
                if(i+1 < len && (s.charAt(i) == '1'|| (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    dp[i] += dp[i+2];
                }

            }
        }

        return dp[0];
    }
}
