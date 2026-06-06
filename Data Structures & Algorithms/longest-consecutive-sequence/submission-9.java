public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;
        //res=longest consec ans
        //curr=expected curr no,. in seq
        //curr consec seq len
        while (i < nums.length) {
            if (curr != nums[i]) {//start new seq
                curr = nums[i];
                streak = 0;//reset to 0
            }
            while (i < nums.length && nums[i] == curr) {
                i++;//dups skips
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}