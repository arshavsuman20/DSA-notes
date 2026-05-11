class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        Arrays.fill(freq,0);
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int windowSize=s1.length();
        for(int i=0;i<s2.length();i++){
            int windowIdx=0, idx=i;
            int windowFreq[]=new int[26];
            Arrays.fill(windowFreq,0);
            while(windowIdx<windowSize && idx<s2.length()){
                windowFreq[s2.charAt(idx)-'a']++;
                windowIdx++; idx++;
            }
            if(isFreqSame(freq,windowFreq)){
                return true;
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
