class Solution {
    public int minCost(int n) {
       if(n<=1) return 0;
       return (n/2*(n-n/2))+minCost(n/2)+minCost(n-n/2);
    }
}