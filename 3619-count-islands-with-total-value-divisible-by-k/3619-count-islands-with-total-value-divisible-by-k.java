class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ct = 0;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    long s = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    s += grid[i][j];
                    q.offer(new int[] { i, j });
                    grid[i][j] = 0;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] > 0) {
                                s += grid[nr][nc];
                                grid[nr][nc] = 0;
                                q.offer(new int[] { nr, nc });
                            }
                        }

                    }
                    if (s % k == 0) {
                        ct++;
                    }
                }
            }
        }
        return ct;

    }
}