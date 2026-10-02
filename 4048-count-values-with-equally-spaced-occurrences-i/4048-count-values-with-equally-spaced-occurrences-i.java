class Solution {
    public int countSpecialIntegers(int[] nums) {
        int [] freq = new int[101];
        for(int i = 0;i<nums.length;i++){
            freq[nums[i]]++;
        }
       int specialCount = 0;

        for (int val = 1; val <= 100; val++) {
            if (freq[val] == 3) {
                int[] idx = new int[3];
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == val) {
                        idx[count++] = i;
                    }
                }
                if (idx[1] - idx[0] == idx[2] - idx[1]) {
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
}