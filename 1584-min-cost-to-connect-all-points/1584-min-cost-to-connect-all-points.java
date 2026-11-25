import java.util.*;

class Solution {
    int[] parent, rank;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int totalEdges = n * (n - 1) / 2;
        int[][] edges = new int[totalEdges][3];

        // 1. Store all edges as [u, v, dist]
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges[idx++] = new int[]{i, j, dist};
            }
        }

        // 2. Sort edges by distance
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        // 3. Initialize DSU arrays
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 4. Kruskal's loop
        int mstCost = 0, edgesUsed = 0;
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                mstCost += e[2];
                edgesUsed++;
                if (edgesUsed == n - 1) break; // Early exit once MST is complete
            }
        }
        return mstCost;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}