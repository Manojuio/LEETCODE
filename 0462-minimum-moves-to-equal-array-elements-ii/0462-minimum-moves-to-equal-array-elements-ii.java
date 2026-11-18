class Solution {
    public int minMoves2(int[] nums) {
        int ans= 0;
        int avg = 0;
        Arrays.sort(nums);
        avg = nums[nums.length/2];
        for(int i = 0;i<nums.length;i++){
            ans +=(Math.abs(nums[i]-avg));
        }
        return ans;
    }
}