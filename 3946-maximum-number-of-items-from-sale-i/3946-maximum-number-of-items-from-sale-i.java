class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n= items.length;
        int[] bonus = new int[n];

        for(int i=0;i<n;i++){
            int factor = items[i][0];
            for(int j=0;j<n;j++){
                if(i!=j && items[j][0]% factor==0){
                    bonus[i]++;
                }
            }
        }
        int[] dp= new int[budget+1];
        for(int i=0;i<n;i++){
            int price = items[i][1];
            int[] ndp= dp.clone();
            for(int b=budget;b>=price;b--){
                ndp[b] = Math.max(
                    ndp[b],
                    dp[b - price] + 1 + bonus[i]
                );
            }
            for(int b = price;b<=budget;b++){
                ndp[b] = Math.max(
                    ndp[b],
                    ndp[b - price] + 1
                );
            }
            dp= ndp;
        }
        int ans = 0;
        for (int x : dp) {
            ans = Math.max(ans, x);
        }

        return ans;
    }
}