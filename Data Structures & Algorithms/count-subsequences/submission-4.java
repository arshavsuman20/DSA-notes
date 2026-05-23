class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[] dp = new long[m + 1];
        dp[m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            long[] curr = Arrays.copyOf(dp, m + 1);
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    curr[j] = dp[j + 1] + dp[j];
                }
                else {
                    curr[j] = dp[j];
                }
            }
            dp = curr;
        }
        return (int)dp[0];
    }
}