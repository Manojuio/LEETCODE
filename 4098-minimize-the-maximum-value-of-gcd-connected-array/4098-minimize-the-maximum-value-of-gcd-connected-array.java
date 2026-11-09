class Solution {
    public long minimumMaxValue(int n, int index, int value) {

        if (value == 1) {
            return -1;
        }
        long p = value;

        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                p = i;
                break;
            }
        }
        if (value - p < 2L * index) {
            return -1;
        }

        if (index == n - 1) {
            return value;
        }
        long right = n - index - 1;

        return value + p + 2L * (right - 1);
    }
}