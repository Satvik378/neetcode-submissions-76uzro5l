class Solution {

    Set<Integer> colSet = new HashSet<>();
    Set<Integer> postDiagSet = new HashSet<>();
    Set<Integer> negDiagSet = new HashSet<>();
    int result = 0;

    public int totalNQueens(int n) {
        dfs(n, 0);
        return result;
    }

    private void dfs(int n, int row){

        if(row == n){
            result++;
            return;
        }

        for(int col = 0; col <n; col++){
            if(!colSet.contains(col) && !postDiagSet.contains(row+col) && !negDiagSet.contains(row-col)){

                colSet.add(col);
                postDiagSet.add(row+col);
                negDiagSet.add(row-col);

                dfs(n, row+1);

                colSet.remove(col);
                postDiagSet.remove(row+col);
                negDiagSet.remove(row-col);
            }
        }
    }
}