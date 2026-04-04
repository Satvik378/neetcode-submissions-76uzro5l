class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        int[][] dist = new int[rows][cols];
        
        for(int i =0; i<rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = 
                new PriorityQueue<>((a,b) -> a[0]-b[0]);

        minHeap.offer(new int[]{0, 0, 0}); //diff, row, col

        while(!minHeap.isEmpty()){
            
            int[] curr = minHeap.poll();
            int diff = curr[0], row = curr[1], col = curr[2];
            
            if(row == rows-1 && col == cols-1) return diff;

            if(diff > dist[row][col]) continue;

            for(int[] direc : directions){
                int newRow = row + direc[0];
                int newCol = col + direc[1];

                if(newRow >=0 && newCol >=0 && newRow < rows && newCol <cols){
                    
                    int difference = Math.max(diff, 
                        Math.abs(heights[newRow][newCol]- heights[row][col]));

                    if(difference < dist[newRow][newCol]){
                        dist[newRow][newCol] = difference;

                        minHeap.offer(new int[]{
                        difference,
                        newRow,
                        newCol
                        });
                    }
                    
                }
            }

        }

        return -1;
    }
}