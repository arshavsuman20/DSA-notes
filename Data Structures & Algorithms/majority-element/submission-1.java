public class Solution {
    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int n = nums.length;

        while (true) {
            int candidate = nums[rand.nextInt(n)];
            int count = 0;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }
            if (count > n / 2) {
                return candidate;
            }
        }
    }
}