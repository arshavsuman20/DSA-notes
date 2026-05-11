class Solution {
    Set<List<Integer>> s=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        getAllCombinations(arr,0,target,ans,comb);
        return ans;
    }
    void getAllCombinations(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> comb){
        if(idx==arr.length || target<0) return;
        if(target==0){
            List<Integer> temp=new ArrayList<>(comb);
            if(!s.contains(temp)){
                ans.add(temp);
                s.add(temp);
            }
            return;
        }
        comb.add(arr[idx]);
        getAllCombinations(arr,idx+1,target-arr[idx],ans,comb); //single
        getAllCombinations(arr,idx,target-arr[idx],ans,comb); //multiple
        comb.remove(comb.size()-1);
        getAllCombinations(arr,idx+1,target,ans,comb); //exclusion
    }

}