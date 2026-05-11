class Solution {
    public int maxArea(int[] heights) {
        int left=0, right=heights.length-1, ans=0;
        while(left<right){
            int width=right-left;
            int height=Math.min(heights[left], heights[right]);
            int area=width*height;
            ans=Math.max(ans, area);
            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}
