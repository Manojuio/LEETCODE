class Solution {
    public int twoEggDrop(int n) {
       int drops = 0;
        while (n > 0) {
            drops++;
            n -= drops;
        }
        return drops;
    }
}