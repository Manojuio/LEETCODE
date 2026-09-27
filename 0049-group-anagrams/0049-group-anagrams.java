class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> hm = new HashMap<>();
        
        for(String s: strs){
            
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String cu = new String(c);
            if(!hm.containsKey(cu)){
                hm.put(cu,new ArrayList<>());
            }
            hm.get(cu).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}