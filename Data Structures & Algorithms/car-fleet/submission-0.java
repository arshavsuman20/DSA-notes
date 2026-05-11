class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] temp=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            temp[i][0]=position[i];
            temp[i][1]=speed[i];
        }
        Arrays.sort(temp,(a,b)->Integer.compare(b[0],a[0]));
        Stack<Double> st=new Stack<>();
        for(int[] t:temp){
            st.push((double)(target-t[0])/t[1]);
            if(st.size()>=2 && st.peek() <= st.get(st.size()-2)){
                st.pop();
            }
        }
        return st.size();
    }
}
