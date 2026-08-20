class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        //1st window
        for(int i=0;i<k;i++){
            while(dq.size() > 0 && nums[dq.getLast()] <= nums[i]) dq.pollLast();
            dq.addLast(i);
        }
        for(int i=k;i<nums.length;i++){
            res.add(nums[dq.getFirst()]);
            //remove not part of curr wind
            while(dq.size()>0 && dq.getFirst() <= i-k)dq.pollFirst();
            while(dq.size()>0 && nums[dq.getLast()] <= nums[i])dq.pollLast();
            dq.addLast(i);
        }
        res.add(nums[dq.getFirst()]);
        int[] arr=new int[res.size()];
        for(int i=0;i<res.size();i++){arr[i]=res.get(i);}
        return arr;
    }
}
