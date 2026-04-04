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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        //edge case if root is null
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode current = root;

        while(true){
            if(val > current.val){
                if(current.right == null){
                    current.right = new TreeNode(val);
                    return root;
                }
                current = current.right;
            }
            else{
                if(current.left == null){
                    current.left = new TreeNode(val);
                    return root;
                }
                current = current.left; 
            }
        }

        
    }
}