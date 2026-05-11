class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combsum(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
    void combsum(int[] arr,int idx, int target, List<List<Integer>> ans, List<Integer> comb){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;
            comb.add(arr[i]);
            combsum(arr, i+1 , target-arr[i] , ans , comb);
            comb.remove(comb.size()-1);
        }
    }

}