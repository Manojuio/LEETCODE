class Solution {
    public int findClosest(int x, int y, int z) {
        int n = Math.abs(z - x);
        int m = Math.abs(z - y);
        if (m == n)
            return 0;
        if (m > n)
            return 1;
        if (n > m)
            return 2;
     return 0;
    }
}