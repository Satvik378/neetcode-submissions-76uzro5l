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
    public List<List<Integer>> levelOrder(TreeNode root) {

        //breadth first search
        //use queue.
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        //when poll -> add children.

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            //traverse
            for(int i = 0; i<size; i++){
                TreeNode current = queue.poll();
                list.add(current.val);
                
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }

            res.add(list);
        }
        
        return res;
    }
}
