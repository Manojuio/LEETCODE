// Disjoint Set Union (DSU) with Path Compression & Union by Rank
// Time Complexity: O(α(N)) ≈ O(1) amortized per operation
class Ds {
    int[] p; // parent[i]: stores parent of node i (if p[i] == i, i is a root)
    int[] r; // rank[i]: upper bound on height of tree rooted at i

    Ds(int n) {
        p = new int[n];
        r = new int[n]; // initialized to 0 by default in Java
        for (int i = 0; i < n; i++) {
            p[i] = i; // initially, every node is its own isolated component
        }
    }

    // Find Ultimate Parent (with Path Compression)
    int fup(int node) {
        if (p[node] == node) return node; // base case: reached the root
        // Recursively find root AND attach node directly to root to flatten tree
        return p[node] = fup(p[node]);
    }

    // Union by Rank: attach shorter tree under taller tree to prevent skew
    void unionofu(int u, int v) {
        int pu = fup(u); // always compare/connect ROOTS, never raw nodes u, v
        int pv = fup(v);

        if (pu == pv) return; // already in the same set -> adding this edge creates a cycle

        if (r[pu] > r[pv]) {
            p[pv] = pu; // pv's tree is shorter -> attach under pu (rank unchanged)
        } else if (r[pu] < r[pv]) {
            p[pu] = pv; // pu's tree is shorter -> attach under pv (rank unchanged)
        } else {
            p[pv] = pu; // equal rank -> attach either way and increment new root's rank
            r[pu]++;
        }
    }
}

// Kruskal's Minimum Spanning Tree (MST) Algorithm
// Overall Time: O(N^2 log N) | Overall Space: O(N^2) for storing all edges
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // 1. Build complete graph: N points have N*(N-1)/2 unique undirected pairs
        int te = n * (n - 1) / 2;
        int k = 0;
        int[][] e = new int[te][3]; // each edge: {point_i, point_j, manhattan_dist}

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0];
                int y = points[i][1];
                int a = points[j][0];
                int b = points[j][1];
                int d = Math.abs(x - a) + Math.abs(y - b);

                e[k][0] = i;
                e[k][1] = j;
                e[k][2] = d;
                k++;
            }
        }

        // 2. Greedy step: sort all edges in ascending order of weight (cost)
        // Use Integer.compare to avoid integer overflow compared to (a[2] - b[2])
        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));

        // 3. Pick smallest edges that don't form a cycle until we have (N - 1) edges
        int ans = 0;
        int eu = 0; // edges used so far
        Ds ds = new Ds(n);

        for (int i = 0; i < e.length; i++) {
            int u = e[i][0];
            int v = e[i][1];
            int c = e[i][2];

            // Only include edge if u and v belong to different components
            if (ds.fup(u) != ds.fup(v)) {
                ds.unionofu(u, v);
                ans += c;
                eu++;
                // Optimization: a tree with N vertices always has exactly N - 1 edges
                if (eu == n - 1) break;
            }
        }

        return ans;
    }
}