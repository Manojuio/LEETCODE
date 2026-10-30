
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[]{v, w});
        }

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long c = curr[0];
            int node = (int) curr[1];
            int cnt = (int) curr[2];

            if (c != dist[node][cnt]) {
                continue;
            }

            if (node == n - 1) {
                return (int) c;
            }

            for (int[] edge : adj[node]) {

                int v = edge[0];
                int w = edge[1];

                int newCnt;

                if (labels.charAt(node) == labels.charAt(v)) {
                    newCnt = cnt + 1;
                } else {
                    newCnt = 1;
                }

                if (newCnt > k) {
                    continue;
                }

                long newCost = c + w;

                if (newCost < dist[v][newCnt]) {

                    dist[v][newCnt] = newCost;

                    pq.offer(new long[]{
                        newCost, v, newCnt
                    });
                }
            }
        }

        return -1;
    }
}
