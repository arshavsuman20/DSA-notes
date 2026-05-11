class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        int prev2=2, prev1=3, curri=0;
        for(int i=3;i<n;i++){
            curri=prev2+prev1;
            prev2=prev1;
            prev1=curri;
        }
        return curri;
    }
}