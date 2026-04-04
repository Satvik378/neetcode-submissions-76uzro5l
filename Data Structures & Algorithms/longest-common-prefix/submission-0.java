class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int len = Integer.MAX_VALUE;
        String res = "";

        for(String str : strs){
            if(len > str.length()){
                len = str.length();
                res = str;
            }
        }

        for(int i = 0; i<len; i++){
            
            for(int j = 0; j<strs.length; j++){
                if(res.charAt(i) != strs[j].charAt(i)){
                    return res.substring(0, i);
                }
            }
        }

        return res;
    }
}