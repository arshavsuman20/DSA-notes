class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1; i>=0; i--){ //end of array
            ++digits[i]; //increment value at last by 1
            digits[i]%=10; //mod by 10
            if(digits[i]!=0){ //result!=0 means no carry 
                return digits;
            }
        }
        digits = new int[n+1];
        digits[0]=1;
        return digits;
    }
}