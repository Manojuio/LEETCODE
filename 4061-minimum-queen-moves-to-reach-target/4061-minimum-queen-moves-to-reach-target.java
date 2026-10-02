class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int sr = source[0];
        int sc = source[1];
        int tr = target[0];
        int tc = target[1];
        if(sr==tr && sc ==tc) return 0;
        if(sr == tr || sc==tc ) return 1;
        if(Math.abs(sr-tr)==Math.abs(sc-tc)) return 1;
        return 2;

    }
}