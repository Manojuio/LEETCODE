class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ms  = 0;
        for(int i = 1;i<=n;i++){
            int o = i;
            int s = 0;
            while(o>0){
                s += o % 10;
                o = o/10;
            }
            int cs =hm.getOrDefault(s,0)+1;
            hm.put(s,cs);
            ms = Math.max(ms,cs);
            
        }
        int r = 0;
        for(int i:hm.values()){
            if(i==ms){
                r++;
            }
        }    
        return r;
    }
}