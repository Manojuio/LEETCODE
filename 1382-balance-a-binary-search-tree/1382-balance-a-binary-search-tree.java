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
    ArrayList<Integer> ls = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return bb(0,ls.size()-1);
    }
    void inorder(TreeNode n){
        if(n == null) return ;
        inorder(n.left);
        ls.add(n.val);
        inorder(n.right);

    }
    TreeNode bb(int i,int j ){
        if(i>j) return null;
        int m = (i+j)/2;
        TreeNode r = new TreeNode(ls.get(m));
        r.left = bb(i,m-1);
        r.right = bb(m+1,j);
            return r;
            }
}