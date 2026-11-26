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

        int fup(int node) {
            if (p[node] == node)
                return node;
            return p[node] = fup(p[node]);
        }

        void unionofu(int u, int v) {
            int pu = fup(u);
            int pv = fup(v);
            if (pu == pv)
                return;
            if (r[pu] > r[pv]) {
                p[pv] = pu;
            } else if (r[pu] < r[pv]) {
                p[pu] = pv;
            } else {
                p[pv] = pu;
                r[pu]++;
            }
        }

        boolean is(int u, int v) {
            return fup(u) == fup(v);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m<n-1) return -1;
        
        Ds ds = new Ds(n);
        int cnt  = n;
        for(int i = 0;i<m;i++){
                int u = connections[i][0];
                int v = connections[i][1];
                if(!ds.is(u,v)){
                    ds.unionofu(u,v);
                    cnt--;
                }
        }

    return cnt-1;
    }
}

