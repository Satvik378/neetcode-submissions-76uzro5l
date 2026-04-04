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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while(current!=null || !stack.isEmpty()){

            if(current!=null){

                res.add(current.val);
                //after visiting left why cmng back to root, go straight to right
                if(current.right!=null){
                    stack.push(current.right);
                }
                
                current = current.left;
            } 
            else{
                current = stack.pop();
            }
            
        }

        return res;  
    }
}