class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){ 
            if(nums[i]>0)break; //if first is only +ve then sum!=0
            if(i>0 && nums[i]==nums[i-1])continue; //s kip duplicate first ele
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //skip duplicate left values
                    while(left<right && nums[left]==nums[left-1])left++;
                }
                else if(sum>0) right--; //sum bigger, move right inwards
                else left++; //sum smaller, increase left
            }
        }
        return ans;
    }
}
