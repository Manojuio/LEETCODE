class Solution {
    public int minimumOperations(int[] nums) {
        int c = 0;
        for(int n:nums){
            
            if(n%3!=0){
                c++;
            }

        }
        return c;
    }
}