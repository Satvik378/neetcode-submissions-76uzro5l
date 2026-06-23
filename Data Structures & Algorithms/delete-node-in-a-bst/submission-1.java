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
            //search left
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            //key found.

            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }
            else{

                //2 children.
                //return the smallest node in the right subtree.
                TreeNode current = root.right;

                while(current.left!=null){
                    current = current.left;
                }

                root.val = current.val;
                root.right = deleteNode(root.right, current.val);
            }
        }

        return root;
    }
}