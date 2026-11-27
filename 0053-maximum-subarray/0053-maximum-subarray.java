class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int cs = 0;
        int ms=Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            cs = Math.max(nums[i],cs+nums[i]);
            ms = Math.max(ms,cs);
        }
        return ms;
    }
}