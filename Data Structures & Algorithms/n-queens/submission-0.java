class Solution {

    Set<Integer> colSet = new HashSet<>();
    Set<Integer> posDiagSet = new HashSet<>();
    Set<Integer> negDiagSet = new HashSet<>();

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];

        for(char[] c : board){
            Arrays.fill(c, '.');
        }
        
        dfs(0, n, board);

        return res;
    }

    private void dfs(int row, int n, char[][] board){

        if(row == n){
            //means we have traversed all rows and placed.
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            res.add(temp);
            return;
        }
        for(int col = 0; col <n; col++){
            if(!colSet.contains(col) && !posDiagSet.contains(row+col) && !negDiagSet.contains(row-col)){
                //we can place the queen at current row.
                board[row][col] = 'Q';
                colSet.add(col);
                posDiagSet.add(row+col);
                negDiagSet.add(row-col);

                dfs(row+1, n, board);

                board[row][col] = '.';
                colSet.remove(col);
                posDiagSet.remove(row+col);
                negDiagSet.remove(row-col);
            }
        }
    }
    
}
