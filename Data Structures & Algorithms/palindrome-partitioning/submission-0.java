class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, s);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> currentList, int index, String s){
        if(index >= s.length()){
            //reached end of string.
            res.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = index; i<s.length(); i++){

            String temp = s.substring(index, i+1);

            if(isPallindrome(temp)){
                currentList.add(temp);
                dfs(res, currentList, i + 1, s);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private boolean isPallindrome(String str){

        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left)!= str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
