class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        while(left < right){
            int currsum = numbers[left] + numbers[right];
            if(currsum>target){ //current sum > target then right side greater so --
                right--;
            }
            else if(currsum<target){ //sum small so left++
                left++;
            }
            else{ //return ans 
                return new int[]{left+1, right+1};
            }
        }
        return new int[0];
    }
}
