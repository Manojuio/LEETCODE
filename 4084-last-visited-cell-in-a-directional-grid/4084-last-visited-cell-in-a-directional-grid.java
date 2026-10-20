class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        
        v[0][0] = true;
       int r = 0;
       int c = 0;
        while (true) {
           
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
            if (nr < 0 || nr>=m || nc < 0 || nc >=n || v[nr][nc]) {
                
                return new int[] { r, c };
            }
            r = nr;
            c = nc;
            v[r][c]=true;

        }
        
    }
}