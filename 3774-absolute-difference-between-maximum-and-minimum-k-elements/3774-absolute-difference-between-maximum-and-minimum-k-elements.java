import java.util.Arrays;

class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int minSum = 0;
        int maxSum = 0;
        
        for (int i = 0; i < k; i++) {
            minSum += nums[i];          // k smallest elements
            maxSum += nums[n - 1 - i];   // k largest elements
        }
        
        return Math.abs(maxSum - minSum);
    }
}