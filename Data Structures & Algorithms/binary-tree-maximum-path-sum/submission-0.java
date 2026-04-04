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
        int[] res = new int[]{root.val};
        dfs(root, res);

        return res[0];
    }

    private int dfs(TreeNode root, int [] res){

        if(root == null) return 0;

        int leftMax = dfs(root.left, res);
        int rightMax = dfs(root.right, res);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        res[0] = Math.max(res[0], root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
