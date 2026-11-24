class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
     
        
        int h  =1;
        for(int i = n-1;i>=0;i--){
            if(citations[i]>=h){
                h++;
            }
            else{
                break;
            }
        }
        return h-1;
    }
}