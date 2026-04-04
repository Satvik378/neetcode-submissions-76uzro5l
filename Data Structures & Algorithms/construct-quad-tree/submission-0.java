/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    private Node dfs(int[][] grid, int n, int row, int column){

        boolean allSameValues = true;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[row][column] != grid[i+row][j+column]){
                    allSameValues = false;
                    break;
                }
            }
        }

        if(allSameValues){
            return new Node(grid[row][column] == 1 ? true: false, true);
        }
        else{
           //divide into subgrids
           n = n/2;
           Node topLeft = dfs(grid, n, row, column);
           Node topRight = dfs(grid, n, row, column+n);
           Node bottomLeft = dfs(grid, n, row+n, column); 
           Node bottomRight = dfs(grid, n, row+n, column+n); 

           return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}