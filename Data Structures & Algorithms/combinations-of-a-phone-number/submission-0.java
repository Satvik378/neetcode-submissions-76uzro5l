class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", 
        "tuv", "wxyz"};
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) return res;

        dfs(0, digits, arr, res, new StringBuilder());

        return res;
    }

    private void dfs(int index, String digits, String[] arr, List<String> res, StringBuilder builder){

        if(index == digits.length()){
            //traversed the whole string
            res.add(builder.toString());
            return;
        }

        String temp = arr[digits.charAt(index)-'0'];

        for(char c : temp.toCharArray()){
            builder.append(c);
            dfs(index+1, digits, arr, res, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}