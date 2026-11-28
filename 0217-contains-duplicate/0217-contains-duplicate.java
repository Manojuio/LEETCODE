class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                return true;
            }
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        return false;
    }
}