class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1, cnt = 0;

        for (int i = 0; i < n; i++) {
            int r = nums[i] % k;

            if (i > 0 && nums[i - 1] % k == r) {
                cnt++;
            } else {
                cnt = 1;
            }

            if ((long) r * (cnt - 1) % k == 0) {
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}