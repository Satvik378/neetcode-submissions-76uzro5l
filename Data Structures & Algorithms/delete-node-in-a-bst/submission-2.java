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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;

        if(root.val == key){
            //root.left == null and root == key therefore right takes root place
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{

                //we found that root == key
                //but neither left = null nor right. = null
                //in this case we pick the smallest from the right subtree.

                TreeNode current = root.right;

                while(current.left!=null){
                    current = current.left;
                }
                root.val = current.val;
                root.right = deleteNode(root.right, current.val);
            }
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}