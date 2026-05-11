class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        getPerms(nums, 0, ans);
        return ans;
    }
    void getPerms(int[] nums, int idx, List<List<Integer>> ans){
        int n=nums.length;
        if(idx==n){
            List<Integer> temp=new ArrayList<>();
            for(int num:nums) temp.add(num);
            ans.add(temp);
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,idx,i);
            getPerms(nums,idx+1,ans);
            swap(nums,idx,i);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}