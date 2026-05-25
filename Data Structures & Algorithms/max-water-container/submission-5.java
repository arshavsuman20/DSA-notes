class Solution {
    public int maxArea(int[] heights) {
        int left=0, right=heights.length-1, ans=0;
        while(left<right){
            int width=right-left; //right most determines wall length, not to overflow.
            int height=Math.min(heights[left], heights[right]);
            int area=width*height; 
            ans=Math.max(ans, area);
            if(heights[left] < heights[right]){
                left++; //left ka height small, so increase left
            }
            else{
                right--; //same for right
            }
        }
        return ans;
    }
}
