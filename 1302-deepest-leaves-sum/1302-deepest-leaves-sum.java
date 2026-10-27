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
    int ans;
    int md = 0;

    public int deepestLeavesSum(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;

    }

    private void dfs(TreeNode n, int d) {
        if (n == null)
            return;
        if (d > md) {
            md = d;
            ans = n.val;
        } else if (d == md) {
            ans += n.val;
        }
        dfs(n.left,d+1);
        dfs(n.right,d+1);
    }
}