class Solution {
    public int minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len / 2;

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        // left[i] = subset sums choosing i elements from left half
        // right[i] = subset sums choosing i elements from right half
        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate all subsets of both halves
        generate(nums, 0, n, 0, 0, left);
        generate(nums, n, len, 0, 0, right);

        // Sort right side so we can binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Pick i elements from left
        for (int i = 0; i <= n; i++) {

            // Therefore pick n-i elements from right
            int j = n - i;

            for (int sumLeft : left[i]) {

                // We want:
                // sumLeft + sumRight ≈ total / 2

                int target = total / 2 - sumLeft;

                List<Integer> list = right[j];

                int pos = Collections.binarySearch(list, target);

                if (pos < 0) {
                    pos = -pos - 1;
                }

                // Candidate at pos
                if (pos < list.size()) {
                    int sumA = sumLeft + list.get(pos);
                    int sumB = total - sumA;

                    ans = Math.min(ans,
                            Math.abs(sumA - sumB));
                }

                // Candidate just before pos
                if (pos > 0) {
                    int sumA = sumLeft + list.get(pos - 1);
                    int sumB = total - sumA;

                    ans = Math.min(ans,
                            Math.abs(sumA - sumB));
                }
            }
        }

        return ans;
    }

    // Pick / Not-Pick recursion
    void generate(
            int[] nums,
            int index,
            int end,
            int count,
            int sum,
            List<Integer>[] result) {

        // All elements of this half processed
        if (index == end) {
            result[count].add(sum);
            return;
        }

        // Pick
        generate(
                nums,
                index + 1,
                end,
                count + 1,
                sum + nums[index],
                result
        );

        // Not Pick
        generate(
                nums,
                index + 1,
                end,
                count,
                sum,
                result
        );
    }
}