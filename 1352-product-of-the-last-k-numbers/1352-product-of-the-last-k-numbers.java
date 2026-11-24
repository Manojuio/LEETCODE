class ProductOfNumbers {
   int[] nums;
   int i;
    public ProductOfNumbers() {
        nums  = new int[40001];
        int i = 0;
    }
    
    public void add(int num) {
        nums[i++]=num;
    }
    
    public int getProduct(int k) {
        int  p =1;
        for(int j = i-k;j<i;j++){
            p *= nums[j];
        }
        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */