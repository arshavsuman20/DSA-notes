class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();//convert in same case
        int st=0, end=s.length()-1;
        while(st<end){
            if(!isAlpha(s.charAt(st))){ //skip left non-alphanumeric chars
                st++; continue;
            }
            if(!isAlpha(s.charAt(end))){ //skip right non-alphanumeric chars
                end--;continue;
            } 
            if(s.charAt(st) != s.charAt(end)){ //chars compare
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
