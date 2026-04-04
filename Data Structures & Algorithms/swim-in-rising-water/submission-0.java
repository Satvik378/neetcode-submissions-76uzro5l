class Solution {
    public int swimInWater(int[][] grid) {
        
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        int rows = grid.length;
        int cols  = grid[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited = new boolean[rows][cols];

        minHeap.offer(new int[]{grid[0][0], 0, 0}); //dist, row, col

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            int dist = curr[0], row = curr[1], col = curr[2];

            if(row == rows-1 && col == cols-1) return dist;
            if(visited[row][col]) continue;

            visited[row][col] = true;

            for(int[] direc : directions){
                int newRow = direc[0] + row;
                int newCol = direc[1] + col;

                if(newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols
                && !visited[newRow][newCol]){

                    minHeap.offer(new int[]{
                        Math.max(dist, grid[newRow][newCol]),
                        newRow,
                        newCol
                    });
                }
            }
        }

        return -1;
    }
}
