class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
		for(int i=0;i<n;i++) sum+=arr[i];
		if(sum%2 == 1) return false;
		int target=sum/2;
		return (subsetSumToK(n, target, arr));
	}
	boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[k + 1];
            cur[0] = true; // sum 0 always possible
            for (int target = 1; target <= k; target++) {
                // Option 1: not take current element
                boolean notTaken = prev[target];
                // Option 2: take current element if possible
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                // Store true if either option is true
                cur[target] = notTaken || taken;
            }
            // Move current row to previous for next iteration
            prev = cur;
        }
        // Return if sum k is possible using all elements
        return prev[k];
    }
}