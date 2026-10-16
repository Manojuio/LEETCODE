import java.util.*;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];

        // Step 1: Assume every number >= 2 is prime
        Arrays.fill(prime, true);
        prime[0] = false;
        if (n >= 1) prime[1] = false;

        // Step 2: Mark composite numbers
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int j = p * p; j <= n; j += p) {
                    prime[j] = false;
                }
            }
        }

        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                if (sum + i > s) break;

                ans.add(i);
                sum += i;
            }
        }

        return ans;
    }
}