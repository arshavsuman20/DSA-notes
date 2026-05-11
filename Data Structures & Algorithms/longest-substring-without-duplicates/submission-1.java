class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(); 
        int l=0, r=0, maxlen=0;
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        while(r<n){
            if(hash[s.charAt(r)]!=-1){ //if -1, character already present
                if(hash[s.charAt(r)]>=l){ //inside current window
                    l=hash[s.charAt(r)]+1;//if yes increase l
                }
            }
            int len=r-l+1; //curr win len
            maxlen=Math.max(len,maxlen); 
            hash[s.charAt(r)]=r;//update hash with latest index
            r++;//expand
        }
        return maxlen;
    }
}
