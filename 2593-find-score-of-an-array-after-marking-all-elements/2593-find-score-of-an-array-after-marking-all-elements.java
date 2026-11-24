class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][2];
        for(int i = 0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(i,j)->i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
        boolean [] m = new boolean[n];
        long s = 0;
        for(int[] p:a){
            int v = p[0];
            int i = p[1];
            if(!m[i]){
                s+=v;
                m[i]=true;
                if(i-1>=0) m[i-1]=true;
                if(i+1<n) m [i+1] = true;
            }
        }
        return s;
    }
}