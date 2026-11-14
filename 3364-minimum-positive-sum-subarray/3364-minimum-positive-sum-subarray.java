class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int n=nums.size();
        
    
        for(int i=l;i<=r;i++){
            int s=0;
            for(int t=0;t<i;t++){
                s+=nums.get(t);
            }
            if(s>0){
                min=Math.min(s,min);
            }
            
            for(int j=i;j<n;j++){
                s+=nums.get(j)-nums.get(j-i);
                if(s>0){
                    min=Math.min(s,min);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}