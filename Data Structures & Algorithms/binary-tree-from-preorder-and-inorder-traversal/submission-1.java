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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            hmap.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length-1, 0, inorder.length-1, hmap);
    }

    private TreeNode dfs(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, 
        int inorderEnd, HashMap<Integer, Integer> hmap){
        
        if(preorderStart > preorderEnd || inorderStart > inorderEnd){
                return null;
        }
        
        int temp = hmap.get(preorder[preorderStart]);
        int leftSubTreeSize = temp - inorderStart; 

        TreeNode current = new TreeNode(preorder[preorderStart]);

        current.left = dfs(preorder, preorderStart+1, preorderStart+ leftSubTreeSize,
        inorderStart, temp-1, hmap);

        current.right = dfs(preorder, preorderStart+1+leftSubTreeSize, preorderEnd, 
        temp+1, inorderEnd, hmap);

        return current;
    }
}
