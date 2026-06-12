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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (preorder(p).equals(preorder(q)));
    }
    public String preorder(TreeNode curr){
        if(curr==null) return "null";
        return curr.val + "," + preorder(curr.left) + preorder(curr.right);
    }
}
