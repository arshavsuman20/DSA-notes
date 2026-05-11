class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        Stack<Integer> s=new Stack<>();
        int ans=0;
        for(int i=0;i<height.length;i++){
            while(!s.isEmpty() && height[i]>=height[s.peek()]){
                int temp=height[s.pop()];
                if(!s.isEmpty()){
                    int r=height[i];
                    int l=height[s.peek()];
                    int h=Math.min(r,l) - temp;
                    int w=i-s.peek()-1;
                    ans+=h*w;
                }
            }
            s.push(i);
        }
        return ans;
    }
}
