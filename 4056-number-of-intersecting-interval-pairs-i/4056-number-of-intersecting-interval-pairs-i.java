class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        
        int n = intervals.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int startA = intervals[i][0];
                int endA = intervals[i][1];
                int startB = intervals[j][0];
                int endB = intervals[j][1];
                
                // Overlap condition
                if (startA <= endB && startB <= endA) {
                    count++;
                }
            }
        }
        
        return count;
    
    }
}