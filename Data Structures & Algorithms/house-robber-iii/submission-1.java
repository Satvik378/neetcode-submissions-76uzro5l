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
    HashMap<TreeNode, Integer> cache;
    
    public int rob(TreeNode root) {

        cache = new HashMap<>();
        
        return dfs(root);
    }

    int dfs(TreeNode root){
        if(root == null) return 0;

        if(cache.containsKey(root)) return cache.get(root);

        int res = root.val;

        if(root.right!=null){
            res += dfs(root.right.left) + dfs(root.right.right); 
            //root + grandchildren
        }

        if(root.left!=null){
            res += dfs(root.left.right) + dfs(root.left.left);
            //root + grandchildren
        }

        res = Math.max(res, dfs(root.left) + dfs(root.right));

        cache.put(root, res);

        return res;
    }
}