class Solution {
    int ans = 0;
    public int totalWaviness(int num1, int num2) {
        for(int i =num1 ;i<=num2;i++){
           ans +=f(i);
        }
        return ans;
    }
    private int f(int n){
        String s = String.valueOf(n);
        if(s.length()<3) return 0;
        int cnt = 0;
        int  t = s.length();
        for(int i = 1;i<t-1;i++){
         int p = s.charAt(i-1)-'0';
         int c = s.charAt(i)-'0';
         int nt = s.charAt(i+1)-'0';
         if(p>c && c<nt){
             cnt++;
         }
         else if(c>p && c>nt){
            cnt++;
         }
        }
        return cnt;
    }
}