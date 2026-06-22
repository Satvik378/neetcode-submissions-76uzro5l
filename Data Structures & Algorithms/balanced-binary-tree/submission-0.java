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
    boolean balanced;
    int height;

    Pair(boolean balanced, int height){
        this.balanced = balanced;
        this.height = height;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    private Pair dfs(TreeNode root){
        if(root == null) return new Pair(true, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        boolean balanced = left.balanced && right.balanced &&
                            (Math.abs(left.height - right.height) <=1);
        
        return new Pair(balanced, 1 + Math.max(left.height, right.height));
    }
}
