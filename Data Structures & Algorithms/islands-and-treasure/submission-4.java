class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            
            for(int[] direction:directions){
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if(newRow >= 0 && newCol >=0 && newRow < rows && newCol < cols
                && grid[newRow][newCol] == Integer.MAX_VALUE){
                    q.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 1 + grid[row][col];
                }
            }
        }
    }
}
