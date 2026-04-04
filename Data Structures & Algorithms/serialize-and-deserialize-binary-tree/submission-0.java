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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        //use N for null nodes and delimeter as comma.
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);

        if(builder.length() > 1){
            builder.setLength(builder.length()-1);
        }

        return builder.toString();
    }

    private void dfs(TreeNode root, StringBuilder builder){
        if(root == null){
            builder.append("N,");
            return;
        }

        builder.append(root.val).append(",");

        dfs(root.left, builder);
        dfs(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strArr = data.split(",");
        int[] index = new int[1];
        
        return dfs01(strArr, index);
    }

    private TreeNode dfs01(String[] strArr, int[] index){

        if("N".equals(strArr[index[0]])){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(strArr[index[0]]));
        index[0]++;

        node.left = dfs01(strArr, index);
        node.right = dfs01(strArr, index);

        return node;
    }
}
