class Solution {
    public int minOperations(String s) {
        char f = s.charAt(0);
        char l  = s.charAt(s.length()-1);
        char[] c = s.toCharArray();
       int n = s.length();
        Arrays.sort(c);
        String str = new String(c);
        char ff= str.charAt(0);
        char ll  = str.charAt(s.length()-1);
        if(s.equals(str)) return 0;
        if(str.length()==2) return -1;
        if(f==ff || l==ll) return 1;
        boolean minElsewhere = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == ff) {
                minElsewhere = true;
                break;
            }
        }
        
        boolean maxElsewhere = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ll) {
                maxElsewhere = true;
                break;
            }
        }
        
        if (!minElsewhere && !maxElsewhere) {
            return 3;
        }
        return 2;
    }
}