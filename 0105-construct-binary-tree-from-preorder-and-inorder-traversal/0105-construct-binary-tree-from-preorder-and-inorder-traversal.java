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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return f(preorder, 0, preorder.length - 1,
                 inorder, 0, inorder.length - 1);
    }

    public TreeNode f(int[] p, int ps, int pe,
                      int[] i, int is, int ie) {

        if (ps > pe || is > ie) {
            return null;
        }

        // Preorder → root
        int rv = p[ps];
        TreeNode r = new TreeNode(rv);

        // Find root in inorder
        int ri = is;

        while (i[ri] != rv) {
            ri++;
        }

        // Number of nodes in left subtree
        int ls = ri - is;

        // Left subtree
        r.left = f(
            p,
            ps + 1,
            ps + ls,
            i,
            is,
            ri - 1
        );

        // Right subtree
        r.right = f(
            p,
            ps + ls + 1,
            pe,
            i,
            ri + 1,
            ie
        );

        return r;
    }
}