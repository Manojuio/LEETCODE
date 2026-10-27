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
    int s = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode n){
        if(n==null)return;
        dfs(n.right);
        s+=n.val;
        n.val  = s;
        dfs(n.left);
    }
}