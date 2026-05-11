class Solution {
    public int longestCommonSubsequence(String s, String t){
        int n=s.length();
		int m=t.length();
		int[] prev=new int[m+1]; Arrays.fill(prev, 0);
		int[] curr=new int[m+1]; Arrays.fill(curr, 0);
		for(int j=0;j<=m;j++) prev[j] = 0;

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1) == t.charAt(j-1)) curr[j] = (1 + prev[j-1]);
				else curr[j] = Math.max(prev[j] , curr[j-1]);
			}
			System.arraycopy(curr, 0, prev, 0, m + 1);
		}
		return prev[m];
	}
}