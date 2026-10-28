class Solution {
    int[][] grid;
    int n;
    int m;
    Set<Integer>[][] dp;

    public int minCost(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new HashSet[n][m];
        Set<Integer> ans = f(n - 1, m - 1);
        return Collections.min(ans);

    }

    public Set<Integer> f(int i, int j) {
        Set<Integer> res = new HashSet<>();
        if (i < 0 || j < 0)
            return res;
        if (i == 0 && j == 0) {
            res.add(grid[0][0]);
            return dp[i][j] = res;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        Set<Integer> top = f(i - 1, j);
        Set<Integer> left = f(i, j - 1);

        for (int x : top)
            res.add(x ^ grid[i][j]);

        for (int x : left)
            res.add(x ^ grid[i][j]);

        return dp[i][j] = res ;
    }
}