class Solution {
    class Ds {
        int[] r;
        int[] p;

        Ds(int n) {
          r = new int[n];
        p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                r[i] = 0;
            }
        }
        int fup(int node){
            if(p[node]==node)return node;
            return p[node]= fup(p[node]);
        }
        void unionofu(int u,int v){
            int pu = fup(u);
            int pv = fup(v);
            if (pu == pv) return;
            if(r[pu]>r[pv]){
                p[pv] =pu;
            }
            else if(r[pu]<r[pv]){
                p[pu] =pv;
            }
            else{
                p[pv]=pu;
                r[pu]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int te = n * (n - 1) / 2;
        int k = 0;
        int[][] e = new int[te][3];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0];
                int y = points[i][1];
                int a = points[j][0];
                int b = points[j][1];
                int d = Math.abs(x - a) + Math.abs(y - b);
                e[k][0] = i;
                e[k][1] = j;
                e[k][2] = d;
                k++;
            }
        }
        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));
        int ans = 0;
        int eu = 0;
        Ds ds = new Ds(n);

        for(int i =0;i<e.length;i++ ){
                int u = e[i][0];
                int v = e[i][1];
                int c = e[i][2];
                if(ds.fup(u)!=ds.fup(v)){
                        ds.unionofu(u,v);
                        ans+=c;
                        eu++;
                        if(eu==n-1)break;
                }
        }
        return ans;

    }
}