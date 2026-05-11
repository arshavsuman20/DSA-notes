class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int st=0, end=s.length()-1;
        while(st<end){
            if(!isAlpha(s.charAt(st))){
                st++; continue;
            }
            if(!isAlpha(s.charAt(end))){
                end--;continue;
            }
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++; end--;
        }
        return true;
    }
    boolean isAlpha(char ch){
        if((ch>='0' && ch<='9') ||(ch>='a' && ch<='z')){
            return true;
        }
        return false;
    }
}
