class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26]; //of s1
        Arrays.fill(freq,0);
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++; //fill freq of s1
        }
        int windowSize=s1.length();//window's size is exactly s1.length
        for(int i=0;i<s2.length();i++){ //possible window start
            int windowIdx=0; //chars added in window
            int idx=i; //current index of s2
            int windowFreq[]=new int[26]; //freq array of current window
            Arrays.fill(windowFreq,0);
            while(windowIdx<windowSize && idx<s2.length()){ //build current window
                windowFreq[s2.charAt(idx)-'a']++;
                windowIdx++; idx++;
            }
            if(isFreqSame(freq,windowFreq)){
                return true; // same freq == permutations found
            }
        }
        return false;
    }
    boolean isFreqSame(int[] f1,int[] f2){
        for(int i=0;i<26;i++){
            if(f1[i] != f2[i]){
                return false;
            }
        }
        return true;
    }
}
