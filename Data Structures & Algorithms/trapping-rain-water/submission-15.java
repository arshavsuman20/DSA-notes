class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0, r=n-1;
        int ans=0;
        int lmax=0, rmax=0;
        //calculate smallest boundary wala side's water coz that is the limiting factor
        //water at index i = min(max height on left, max height on right) - height[i]
        while(l<r){
            lmax=Math.max(lmax,height[l]); //update max ht from left
            rmax=Math.max(rmax,height[r]); //update max ht from right
            if(lmax<rmax){ //left side's water depends on only lmax
                ans+=lmax-height[l];
                l++;
            }
            else{ //right side's water depends only on rmax
                ans+=rmax-height[r];
                r--;
            }
        }
        return ans;
    }
}
