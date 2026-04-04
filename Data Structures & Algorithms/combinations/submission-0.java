class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currentList, 
    int index, int n, int k){

        if(currentList.size() == k){
            res.add(new ArrayList<>(currentList));
            return;
        }

        if(index > n){
            return;
        }

        for(int i = index; i<=n; i++){
            currentList.add(i);
            dfs(res, currentList, i+1, n, k);
            currentList.remove(currentList.size()-1);
        }
    }
}