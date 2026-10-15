class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int ans = -100000;
        int n = nums.length;
        int ni = -1;
        int nj =-1;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                int t = ans;
                if(i!=j && nums[i]>nums[j]&& nums[i]+nums[j]==target){
                    int p  = nums[i]*nums[j];
                    if(p>ans){
                        ans = p;
                        ni = i;
                        nj = j;
                    }

                }
            }
        }
        return new int[]{ni,nj};
    }
}