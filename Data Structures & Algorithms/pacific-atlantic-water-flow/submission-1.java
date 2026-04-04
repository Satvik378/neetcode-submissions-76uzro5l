class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int row = 0 ; row < rows; row++){
            dfs(row, 0, heights, pacific, heights[row][0]);
            dfs(row, cols-1, heights, atlantic, heights[row][cols-1]);
        }

        for(int col = 0; col < cols; col++){
            dfs(0, col, heights, pacific, heights[0][col]);
            dfs(rows-1, col, heights, atlantic, heights[rows-1][col]);
        }
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
        
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int prevHt){

        //out of bound conditions
        if(row<0 || col <0 || row >= heights.length || col >= heights[0].length || visited[row][col] ||
        heights[row][col] < prevHt){
            return;
        }

        visited[row][col] = true;

        for(int[] direc : directions){
            int nr = row + direc[0];
            int nc = col + direc[1];

            dfs(nr, nc, heights, visited, heights[row][col]);
        }
    }
}
