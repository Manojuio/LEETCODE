class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] count = new int[101];
        for (int x : nums) {
            count[x]++;
        }

        int[] ans = new int[nums.length];
        int idx = 0;

        while (idx < nums.length) {
            for (int i = 1; i <= 100; i++) {
                if (count[i] > 0) {
                    ans[idx++] = i;
                    count[i]--;
                }
            }
        }

        return ans;
    }
}