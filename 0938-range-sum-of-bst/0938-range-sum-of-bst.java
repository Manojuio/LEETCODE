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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return f(root, low, high);
    }

    public int f(TreeNode n, int l, int h) {
        if (n == null) return 0;

        // If the current node is smaller than low, skip the left subtree
        if (n.val < l) {
            return f(n.right, l, h);
        }

        // If the current node is greater than high, skip the right subtree
        if (n.val > h) {
            return f(n.left, l, h);
        }

        // Current node is within [l, h], so include its value and check both sides
        return n.val + f(n.left, l, h) + f(n.right, l, h);
    }
}