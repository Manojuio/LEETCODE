class Solution{
    public int minimumSumSubarray(List<Integer> nums, int l, int r){
        int  min=Integer.MAX_VALUE;
        int s=0;
        while(l<=r){    
            s=0;
            for(int i=0;i<l;i++){   //first l numbers 
                s+=nums.get(i);
            }
            if(s>0 && s<min){
                min=s;
            }
            for(int i=l;i<nums.size();i++){   //slide the window 
                s-=nums.get(i-l);
                s+=nums.get(i);
                if(s>0 && s<min){
                   min=s;
                }
            }
            l++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}