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

        if(root == null) return root;

        if(root.val > key){
            //move left
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            //found the node to be deleted.

            //few cases arise here
            // if its a leaf node -> no children
            // root has one left or one right -> replace with the leaf.

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                // we will return with the smallest in the right subtree
                TreeNode current = root.right;

                while(current.left != null){
                    current = current.left;
                }

                root.val = current.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
        
    }
}