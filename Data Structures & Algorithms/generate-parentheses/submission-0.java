class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        brackets(0, 0, n, res, sb);
        return res;
    }
    void brackets(int open, int closed, int n, List<String> res, StringBuilder sb){
        if(open == closed && open == n){
            res.add(sb.toString()); return;
        }
        if(open<n){
            sb.append('(');
            brackets(open+1, closed, n, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closed<open){
            sb.append(')');
            brackets(open, closed+1, n, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
