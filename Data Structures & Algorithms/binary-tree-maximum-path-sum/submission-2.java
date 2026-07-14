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

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = root.val;

        dfs(root, res);

        return res[0];
    }

    int dfs(TreeNode root, int[] res){

        if(root == null) return 0;

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        left = Math.max(left,0); //for -ve values
        right = Math.max(right, 0); // for -ve values

        res[0] = Math.max(res[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
