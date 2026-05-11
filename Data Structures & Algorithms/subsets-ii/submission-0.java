class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // List<List<Integer>> res=new ArrayList<>();
        fn(0,new ArrayList<>(), nums);
        return res;
    }
    void fn(int i,List<Integer> subset, int[] nums){
        // List<List<Integer>> res=new ArrayList<>();
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        fn(i+1,subset,nums);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        fn(i+1,subset,nums);
    }
}
