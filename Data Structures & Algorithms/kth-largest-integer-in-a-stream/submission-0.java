class KthLargest {
    PriorityQueue<Integer> mini;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.mini=new PriorityQueue<>();
        for(int num:nums){
            mini.offer(num);
            if(mini.size()>k){
                mini.poll();
            }
        }
    }
    
    public int add(int val) {
        mini.offer(val);
        if(mini.size()>k){
            mini.poll();
        }
        return mini.peek();
    }
}
