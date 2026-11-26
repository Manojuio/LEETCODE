class Solution {
    public boolean canAliceWin(int n) {
        boolean isa = true;
        int k = 10;
        while(n>=k){
            if(isa){
            n-=k;
            k--;
            isa = false;
            }
            else{
                n-=k;
                k--;
                isa = true;
            }
        }
        return !isa;
    }
}