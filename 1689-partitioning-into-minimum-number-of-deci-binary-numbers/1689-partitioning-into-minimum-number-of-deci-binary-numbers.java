class Solution {
    public int minPartitions(String n) {
        int max = 0;
        
        for (int i = 0; i < n.length(); i++) {
            // Convert the character digit to its integer value
            int currentDigit = n.charAt(i) - '0';
            max = Math.max(max, currentDigit);
            
            // Early exit: 9 is the largest possible single digit
            if (max == 9) {
                return 9;
            }
        }
        
        return max;
    }
}