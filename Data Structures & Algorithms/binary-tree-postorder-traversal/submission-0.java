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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {
             // go as left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();

            if(peekNode.right!=null && lastVisited!=peekNode.right){
                current = peekNode.right;
            }
            else{
                res.add(peekNode.val);
                lastVisited = stack.pop();
            }

        }

        return res;
            
    }
}