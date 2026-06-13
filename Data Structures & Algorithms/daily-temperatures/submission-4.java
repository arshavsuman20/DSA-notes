public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //PGEE, previous greater element: a[st.peek()] < a[i];
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>(); //temperature, index
        for (int i = 0; i < temperatures.length; i++) {
            //int t = temperatures[i];
            ///if current temp>tos of stack, top day's ans found
            while (!st.isEmpty() && temperatures[i] > st.peek()[0]) {
                int[] pair = st.pop();
                res[pair[1]] = i - pair[1]; //pair[1]=old index
            }
            st.push(new int[]{temperatures[i], i}); //current day in stack
        }
        return res;
    }
}