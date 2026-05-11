class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        // Impossible cases
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0)
            return 0;

        int K = (totalSum + target) / 2;

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int num : nums) {
            // Traverse backwards to avoid overwriting
            for (int t = K; t >= num; t--) {
                dp[t] += dp[t - num];
            }
        }

        return dp[K];
    }
}
