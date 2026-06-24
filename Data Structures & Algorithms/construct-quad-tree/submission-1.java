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
        //dfs traversal

        return dfs(grid.length, 0, 0, grid);
    }

    private Node dfs(int n, int row, int col, int[][] grid){

        boolean allSame = true;

        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){

                if(grid[row][col] != grid[row+i][col+j]){
                    allSame = false;
                    break;
                }
            }
        }

        if(allSame){
            return new Node(grid[row][col] == 1 ? true : false, true); //leaf node
        }

        //values not same divide into quadrants
        n = n/2;
        Node topLeft = dfs(n, row, col, grid);
        Node topRight = dfs(n, row, col+n, grid);
        Node bottomLeft = dfs(n, row+n, col, grid);
        Node bottomRight = dfs(n, row+n, col+n, grid);

        //internal node
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}