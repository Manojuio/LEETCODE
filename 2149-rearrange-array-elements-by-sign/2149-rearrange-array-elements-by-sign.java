class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ind = new int[n];
        
        int posIdx = 0; // Positive numbers go at even indices: 0, 2, 4, ...
        int negIdx = 1; // Negative numbers go at odd indices: 1, 3, 5, ...
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ind[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ind[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        
        return ind;
    }
}