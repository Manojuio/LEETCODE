import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element class to hold value, digit sum, and original index
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], getDigitSum(nums[i]), i);
        }
        
        // Sort elements by digit sum, with value as tiebreaker
        Arrays.sort(elements, (a, b) -> {
            if (a.sum != b.sum) {
                return Integer.compare(a.sum, b.sum);
            }
            return Integer.compare(a.val, b.val);
        });
        
        // Find permutation cycles to determine the minimum swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct place
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }
            
            // Calculate cycle length
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = elements[curr].originalIndex;
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    private static class Element {
        int val;
        int sum;
        int originalIndex;
        
        Element(int val, int sum, int originalIndex) {
            this.val = val;
            this.sum = sum;
            this.originalIndex = originalIndex;
        }
    }
}