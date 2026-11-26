class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int c = 0 ;
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                c++;
            }
        }
        return c;
        
    }
    public void dfs(int i,boolean[] vis,int[][] isit){
        
        vis[i]=true;
        for(int j = 0;j<isit.length;j++){
            if(isit[i][j]==1 && !vis[j]){
                      dfs(j,vis,isit);
            }
          
        }
    }
}