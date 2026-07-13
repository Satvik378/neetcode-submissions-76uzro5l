class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minutes = 0;

        while(!q.isEmpty() && freshCount > 0){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] current = q.poll();

                int row = current[0];
                int col = current[1];
                
                for(int[] direction : directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if(newRow >=0 && newCol >=0 && newRow < rows && newCol < cols &&
                    grid[newRow][newCol] == 1){
                        q.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2; //rotten
                        freshCount--;
                    }
                }
            }
            minutes++; 
        }

        return freshCount == 0 ? minutes: -1;

    }
}
