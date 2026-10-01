class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        for (String s : words) {
            boolean valid = true;

            for (char ch : s.toCharArray()) {
                if (!allowed.contains(ch + "")) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}