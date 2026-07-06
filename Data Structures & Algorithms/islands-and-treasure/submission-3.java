class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(q.size() == 0) return;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int dist = 0;
        while(!q.isEmpty()){

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];

            for(int[] direction : directions){
                int newRow  = row + direction[0];
                int newCol = col + direction[1];

                if(newRow < 0 || newRow >= grid.length
                || newCol <0 || newCol >= grid[0].length||
                grid[newRow][newCol]!= Integer.MAX_VALUE){
                    continue;
                }

                q.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = 1 + grid[row][col];
            }
        }

    }
}
