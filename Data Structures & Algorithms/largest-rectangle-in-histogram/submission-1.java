class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int ans=0;
        int[] left=leftsmaller(heights);
        int[] right=rightsmaller(heights);
        for(int i=0;i<n;i++){
            int currarea=heights[i] * (right[i] - left[i] - 1);
            ans=Math.max(ans, currarea);
        }
        return ans;
    }
    int[] rightsmaller(int[] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            while(s.size()>0 && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return right;
    }
    int[] leftsmaller(int[] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            while(s.size()>0 && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return left;
    }
}
