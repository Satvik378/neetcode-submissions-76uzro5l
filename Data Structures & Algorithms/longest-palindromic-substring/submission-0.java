class Solution {
    public String longestPalindrome(String s) {
        
        int maxLen = 0;
        String res = "";

        for(int i = 0; i<s.length(); i++){
            //odd length string
            int left = i;
            int right = i;

            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                
                if(right-left +1 > maxLen){
                    maxLen = right-left+1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            //evn length string
            left = i;
            right = i+1;

            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                
                if(right-left +1 > maxLen){
                    maxLen = right-left+1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
