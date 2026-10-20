class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });
        v[0][0] = true;
        int[] last = new int[] { 0, 0 };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            last = curr;
            int nr = r;
            int nc = c;
            if (grid[r][c] == 'L')
                nc--;
            if (grid[r][c] == 'R')
                nc++;
            if (grid[r][c] == 'U')
                nr--;
            if (grid[r][c] == 'D')
                nr++;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[nr][nc]) {
                v[nr][nc] = true;
                q.offer(new int[] { nr, nc });
            } else {
                return last;
            }

        }
        return last;
    }
}