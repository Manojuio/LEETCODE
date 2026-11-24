class Solution {
    public int getKth(int lo, int hi, int k) {
        int[] ans = new int[hi-lo+1];
        for(int i = lo;i<=hi;i++){
            ans[i-lo] = con(i)*10000+i;
        }
        Arrays.sort(ans);
        return ans[k-1]%10000;
    }
    public int con(int n){
        int c = 0;
       while(n!=1){
        if(n%2==0){
            n=n/2;
        }
        else{
            n = 3*n+1;
        }
        c++;
       }
       return c;
    }
}