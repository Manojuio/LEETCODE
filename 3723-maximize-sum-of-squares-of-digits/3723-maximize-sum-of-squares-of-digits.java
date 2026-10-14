class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<num;i++){
            int d = Math.min(9,sum);
            ans.append(d);
            sum-=d;
        }
        return ans.toString();
    }
}