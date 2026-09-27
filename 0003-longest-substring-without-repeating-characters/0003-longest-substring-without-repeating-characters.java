class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(s.charAt(right)) && map.get(c) >= left) {
                left =  map.get(c)+1;
            }
            ans = Math.max(right - left + 1, ans);
            map.put(c,right);
        }
        return ans;
    }
}