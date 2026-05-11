class MinStack {
    Stack<Long> st;
    long mini;
    public MinStack() {
        st=new Stack<>();
        mini=Integer.MAX_VALUE;
    }
    public void push(long val) {
        if(st.isEmpty()){
            mini=val;
            st.push(val);
            return;
        }
        if(val>mini) st.push(val);
        else{
            st.push(2*val-mini);
            mini=val;
        }
    }
    public void pop() {
        if(st.isEmpty())return;
        long x=st.pop();
        if(x<mini) mini=2*mini-x;
    }
    public int top() {
        if(st.isEmpty()) return -1;
        long x=st.peek();
        if(mini<x) return (int)x;
        return (int)mini;
    }
    public int getMin() {
        return (int)mini;
    }
}
