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
    private Map<Integer, Integer> cntmap;
    private int mc;
    public int[] findFrequentTreeSum(TreeNode root) {
        cntmap = new HashMap<>();
        mc = 0;
        dfs(root);
        List<Integer>ls = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:cntmap.entrySet()){
            if(entry.getValue()==mc){
                ls.add(entry.getKey());
            }
        }
        int [] ans = new int[ls.size()];
        for(int i =0;i<ls.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
    private int dfs(TreeNode n){
        if(n==null) return 0;
        int cs = dfs(n.left)+dfs(n.right)+n.val;
        int c = cntmap.getOrDefault(cs,0)+1;
        cntmap.put(cs,c);
        mc = Math.max(mc,c);
        return cs;

    }
}