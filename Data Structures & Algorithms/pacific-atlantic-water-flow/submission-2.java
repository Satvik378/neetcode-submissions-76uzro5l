class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] atl = new boolean[rows][cols];
        boolean[][] pac = new boolean[rows][cols];
        
        //left and right iteration
        for(int i = 0; i<rows; i++){
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, cols-1, atl, heights[i][cols-1], heights);
        }

        //top and bottom iteration
        for(int j = 0; j<cols; j++){
            dfs(0, j, pac, heights[0][j], heights);
            dfs(rows-1,j, atl, heights[rows-1][j], heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(atl[i][j] && pac[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    void dfs(int row, int col, boolean[][] res, int prevHeight, int[][] heights){

        if(row < 0 || col <0 ||row >= heights.length || col >= heights[0].length
            || heights[row][col] < prevHeight || res[row][col]){
                return;
            }
        
        res[row][col] = true;

        for(int[] direction: directions){
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;

            dfs(newRow, newCol, res, heights[row][col], heights);
        }
    }
}
