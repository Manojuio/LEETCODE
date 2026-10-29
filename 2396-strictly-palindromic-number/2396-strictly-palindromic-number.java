class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s = Integer.toString(n, i);
            if (!f(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(String text) {
        if (text == null)
            return false;

        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }
}