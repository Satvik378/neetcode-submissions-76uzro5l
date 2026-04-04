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

        return dfs(hmap, 0, preorder.length-1, 0, inorder.length-1, preorder);
    }


    public TreeNode dfs(HashMap<Integer, Integer> hmap, int preOrderStart, 
    int preOrderEnd, int inOrderStart, int inOrderEnd, int[] preorder){

        if(preOrderStart > preOrderEnd || inOrderStart > inOrderEnd){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preOrderStart]);

        int temp = hmap.get(preorder[preOrderStart]);

        int leftLength = temp - inOrderStart;

        node.left = dfs(hmap, preOrderStart+1, preOrderStart + leftLength, inOrderStart, temp-1,  preorder);
        node.right = dfs(hmap, preOrderStart + leftLength+1, preOrderEnd, 
        temp+1, inOrderEnd, preorder);

        return node;

    }
}
