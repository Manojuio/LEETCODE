class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
            adj.get(e[1]).add(new int[] { e[0], e[2] });
        }
        int ans = -1;
        int minCount = Integer.MAX_VALUE;
        for (int s = 0; s < n; s++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            dist[s] = 0;
            pq.add(new int[] { 0, s });
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[1];
                int d = curr[0];
                if (d > dist[node])
                    continue;
                for (int[] ne : adj.get(node)) {
                    int adjn = ne[0];
                    int wt = ne[1];
                    if (d + wt < dist[adjn]) {
                        dist[adjn] = d + wt;
                        pq.add(new int[] { dist[adjn], adjn });
                    }
                }
            }
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (j != s && dist[j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                ans = s;
            }

        }
        return ans;

    }
}