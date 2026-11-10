class Solution {
    public int climbStairs(int n, int[] costs) {
    int[] dp  =new int[n+1];
    dp[0] = 0;
    for(int i = 1;i<=n;i++){
        int mc = Integer.MAX_VALUE;
        for(int k =1;k<=3;k++){
          if(i-k>=0){
            int jc = costs[i-1]+(k*k);
            mc = Math.min(mc,dp[i-k]+jc);

          }
        }
        dp[i]= mc;
    }
    return dp[n];


    }
}