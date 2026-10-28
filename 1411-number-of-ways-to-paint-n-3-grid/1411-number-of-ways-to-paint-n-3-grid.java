class Solution {
    public int numOfWays(int n) {
        long type2 = 6; 
        long type3 = 6;
        long mod = 1_000_000_007L;

        for (int i = 2; i <= n; i++) {
            long nextType2 = (3 * type2 + 2 * type3) % mod;
            long nextType3 = (2 * type2 + 2 * type3) % mod;

            type2 = nextType2;
            type3 = nextType3;
        }

        return (int) ((type2 + type3) % mod);
    }
}
