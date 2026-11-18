class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] p = new int[n];
        p[0] = pref[0];
        for(int i = 1;i<n;i++){
            p[i] = pref[i-1]^pref[i];
        }
        return p;
    }
}