class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        
        // 1. Build initial tree from parent[]
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        // 2. Find np[] in one top-down pass instead of the O(N^2) while-loop
        int[] np = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        findParents(0, s, adj, lastSeen, np);

        // 3. Rebuild adj using np[] (your exact code)
        List<List<Integer>> newAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            newAdj.get(np[i]).add(i);
        }

        // 4. Count subtree sizes (your exact dfs)
        int[] ans = new int[n];
        dfs(0, newAdj, ans);
        return ans;
    }

    private void findParents(int node, String s, List<List<Integer>> adj, int[] lastSeen, int[] np) {
        int idx = s.charAt(node) - 'a';
        
        // Closest matching ancestor is simply the last time we saw this character
        if (lastSeen[idx] != -1) {
            np[node] = lastSeen[idx];
        }

        int old = lastSeen[idx]; // Save previous ancestor
        lastSeen[idx] = node;    // Mark current node as latest ancestor for this char

        for (int child : adj.get(node)) {
            findParents(child, s, adj, lastSeen, np);
        }

        lastSeen[idx] = old;     // Restore when leaving this branch
    }

    public int dfs(int node, List<List<Integer>> adj, int[] ans) {
        int s = 1;
        for (int c : adj.get(node)) {
            s += dfs(c, adj, ans);
        }
        ans[node] = s;
        return s;
    }
}