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
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root,null,null);
        return ans;
    }
    private void dfs(TreeNode n,TreeNode p,TreeNode gp){
        if(n==null)return;
       if(gp!=null && gp.val%2==0){
        ans+=n.val;
       }
        dfs(n.left,n,p);
        dfs(n.right,n,p);
    }
}