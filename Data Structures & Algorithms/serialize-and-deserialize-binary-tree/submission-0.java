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
        List<String> list=new ArrayList<>();
        helper(root, list);
        return String.join(",", list);
    }
    void helper(TreeNode node, List<String> list){
        if(node==null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list=new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        return helper2(list);
    }
    TreeNode helper2(List<String> list){
        String value=list.remove(list.size()-1);
        if(value.equals("null")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(value));
        node.left=helper2(list);
        node.right=helper2(list);
        return node;
    }
}
