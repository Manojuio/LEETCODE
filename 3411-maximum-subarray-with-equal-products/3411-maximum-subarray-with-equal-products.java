class Solution {
    public int maxLength(int[] nums) {
        int l = 0;
        int n = nums.length;
        int m = 0;

        for (int r = 0; r < n; r++) {
            
            while (l < r && pr(l, r, nums) != gcd(l, r, nums) * lcm(l, r, nums)) {
                l++;
            }
            m = Math.max(m, r - l + 1);
        }
        return m;
    }


    public long pr(int i, int j, int[] nums) {
        long prod = 1;
        for (int k = i; k <= j; k++) {
            prod *= nums[k];
        }
        return prod;
    }

    public long gcd(int i, int j, int[] nums) {
        long res = nums[i];
        for (int k = i + 1; k <= j; k++) {
            res = findGcd(res, nums[k]);
        }
        return res;
    }

    public long lcm(int i, int j, int[] nums) {
        long res = nums[i];
        for (int k = i + 1; k <= j; k++) {
            res = (res / findGcd(res, nums[k])) * nums[k];
        }
        return res;
    }

 
    private long findGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}