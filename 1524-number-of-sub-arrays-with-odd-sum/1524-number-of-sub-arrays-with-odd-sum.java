class Solution {
    public int numOfSubarrays(int[] arr) {
        int m  = 1000000007;
     
        int ec = 1;
        int oc =  0;
        int cs = 0;
       long ans = 0 ;
        for(int i = 0;i<arr.length;i++){
            cs = cs + arr[i];
            if(cs%2!=0){
              ans = (ans+ec) % m;
              oc++;
            }
           else{
            ans = (ans+oc)%m;
            ec++;
           }
        }
        return (int)ans;
    }
}