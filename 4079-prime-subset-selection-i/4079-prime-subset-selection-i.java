class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        long sum = 0;
        for (int i = 2; i <=n; i++) {
            if (f(i)) {
                if(sum+i<=s){
                ans.add(i);
                sum+=i;
                }
                else{
                    break;
                }
            }
        
        }
        return ans;

    }
       private boolean f(int j){
        for(int i= 2;i*i<=j;i++){
            if(j%i==0) return false;
        }
        return true;
       } 
    
}