class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int ans =0 ;
        for(int  i = 0;i<n-1 ; i+=2){
            int z = 0;
            int o  = 0;
            for(int j = i;j<i+2;j++){
                if(s.charAt(j)=='1'){
                    o++;
                }
                else{
                    z++;
                }
            }
            ans += Math.min(z,o);
        }
        return ans;
    }
}