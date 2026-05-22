class Solution {
    public int climbStairs(int n) {
        int prev2=1, prev1=1, curri=0;
        for(int i=0;i<n-1;i++){
            curri=prev1;
            prev1=prev1+prev2;
            prev2=curri;
        }
        return prev1;
    }
}