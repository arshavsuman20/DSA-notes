class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        boolean[] used=new boolean[n];
        int[] freq=new int[n];
        for(int i=0;i<n;i++){ //freq count for each element
            if(used[i]) continue;
            int count=1;
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                    used[j]=true;
                }
            }
            freq[i]=count;
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){ //pick top k freq element
            int maxfreq=-1; int index=-1;
            for(int j=0;j<n;j++){
                if(!used[j] && freq[j]>maxfreq){
                    maxfreq=freq[j];
                    index=j;
                }
            }
            res[i]=nums[index];
            used[index]=true; //marking picked one
        }
        return res;
    }
}