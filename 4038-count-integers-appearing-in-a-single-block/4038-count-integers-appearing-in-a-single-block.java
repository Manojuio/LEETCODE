import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                map.put(val, new int[]{1, i, i});
            } else {
                int[] data = map.get(val);
                data[0]++;
                data[2] = i;
            }
        }

        int specialCount = 0;
        for (int[] data : map.values()) {
            if (data[2] - data[1] + 1 == data[0]) {
                specialCount++;
            }
        }

        return specialCount;
    }
}