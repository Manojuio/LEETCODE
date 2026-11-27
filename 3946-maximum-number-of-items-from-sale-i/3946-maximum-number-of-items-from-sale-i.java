class Solution {
    int[] bonus;
    int[][] items;
    int n;
    Integer [][][] dp;
    public int maximumSaleItems(int[][] items, int budget) {
        this.items = items;
        this.n = items.length;
        dp = new Integer[n][budget+1][2];
        bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    bonus[i]++;
                }
            }
        }
        return f(0, budget, 0);

    }

    public int f(int i, int rem, int b) {
        
        if (i == n - 1) {
            if (rem >= items[i][1]) {
                int k = rem / items[i][1];

                if (b == 0) {
                    return k + bonus[i];
                }
                return k;
            }
            return 0;
        }
        if(dp[i][rem][b]!=null ) return dp[i][rem][b];
        int p = 0;
        if (rem >= items[i][1]) {
            
            if (b == 0) {
                p = 1 + f(i, rem - items[i][1], 1) + bonus[i];
            } else {
                p = 1 + f(i, rem - items[i][1], 1);
            }
        }
        int np = f(i + 1, rem, 0);
        return dp[i][rem][b]=Math.max(p,np);

    }
}