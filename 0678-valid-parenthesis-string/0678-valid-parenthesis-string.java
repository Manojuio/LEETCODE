class Solution {
    public boolean checkValidString(String s) {
        int l = 0;
        int h = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                h++;
            } else if (c==')') {
                l--;
                h--;
            } else {
                l--;
                h++;
            }
            l = Math.max(l, 0);
            if (h < 0)
                return false;
        }
        return l == 0;
    }
}