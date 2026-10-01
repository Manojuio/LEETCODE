class RandomizedSet {
    
 HashMap<Integer,Integer>hm;
    List<Integer> ls;
    Random ran;
    public RandomizedSet() {
        hm=new HashMap<>();
        ls=new ArrayList<>();
        ran = new Random();
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int i=hm.get(val);
        int lv=ls.get(ls.size()-1);
        ls.set(i,lv);
        hm.put(lv,i);
        ls.remove(ls.size()-1);
        hm.remove(val);
        return true;
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        hm.put(val,ls.size());
        ls.add(val);
        return true;
    }
    
    public int getRandom() {
        int i=ran.nextInt(ls.size());
        return ls.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */