class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        for(int i =0;i<nums.length-1;i++){
            c+=nums[nums.length-1]-nums[i];
        }
        return c;
    }
}