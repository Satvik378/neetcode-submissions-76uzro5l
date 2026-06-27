/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    boolean isBalanced;
    int height;

    Pair(boolean isBalanced, int height){
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return dfs(root).isBalanced;
    }

    private Pair dfs(TreeNode root){
        if(root == null) return new Pair(true, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        boolean balanced = left.isBalanced && right.isBalanced &&
            Math.abs(left.height- right.height) <= 1;

        return new Pair(balanced, 1 + Math.max(left.height, right.height));
    }
}
