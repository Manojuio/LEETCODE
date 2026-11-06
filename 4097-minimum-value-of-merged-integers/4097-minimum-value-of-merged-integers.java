class Solution {
    public int minMergedInteger(int[] nums) {
        int min  =Integer.MAX_VALUE;
        for(int  i = 1;i<nums.length;i=i+2){
           
            StringBuilder m = new StringBuilder();
            m.append(nums[i-1]).append(nums[i]);
            int r = Integer.parseInt(m.toString());
            min  = Math.min(r,min);

        }
        return min;

    }
}