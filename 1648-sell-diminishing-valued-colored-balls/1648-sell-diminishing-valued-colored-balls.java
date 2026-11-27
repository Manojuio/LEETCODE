class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        Arrays.sort(inventory);
        long p = 0;
        int m = 1000000007;
        int i = n - 1;
        while (orders > 0) {
            long c = inventory[i];
            while (i >= 0 && inventory[i] == c) {
                i--;
            }
            long w = n - 1 - i;
            long next =i>=0? inventory[i]:0;
            long b = w * (c - next);
            if (orders >= b) {
                
                long s = (c * (c + 1) / 2) - (next * (next + 1) / 2);
                p=(p+w*s)%m;
                orders -=b;
            }
            else {
                long rows = orders / w;
                long rem = orders % w;
                long end = c - rows;
                long s = (c * (c + 1) / 2) - (end * (end + 1) / 2);
                p = (p + w * s + rem * end) % m;
                orders = 0;
            }
        


        }
        return (int) p;

    }
}