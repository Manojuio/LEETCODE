class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void f(List<String> res, StringBuilder curr, int o, int c, int m) {
        if (curr.length() == m * 2) {
            res.add(curr.toString());
            return;
        }
        if(o<m){
            curr.append('(');
            f(res,curr,o+1,c,m);
            curr.deleteCharAt(curr.length()-1);
        }
        if(c<o){
            curr.append(")");
            f(res,curr,o,c+1,m);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}