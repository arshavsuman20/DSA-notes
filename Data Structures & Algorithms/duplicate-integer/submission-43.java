class Solution {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count()<nums.length;
        //if duplicates exist: unique count < original length
        //if uniques exist: unique count == original length
    }
}